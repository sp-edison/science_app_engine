var InputdeckConstants = {
	VARIABLE_TYPE_STRING : 'string',
	VARIABLE_TYPE_NUMERIC : 'numeric',
	VARIABLE_TYPE_GROUP : 'group',
	VARIABLE_TYPE_COMMENT : 'comment',
	VARIABLE_TYPE_LIST : 'list',
	VARIABLE_TYPE_VECTOR: 'vector',
	VARIABLE_TYPE_FILE: 'file', //deprecated
	BRACE_TYPE_SQUARE:"SQUARE",
	BRACE_TYPE_SQUARE_SPACE:"SQUARE_SPACE",
	BRACE_TYPE_ROUND:"ROUND",
	BRACE_TYPE_ROUND_SPACE:"ROUND_SPACE",
	LOWER_LIMIT : 'lower-limit',
	UPPER_LIMIT : 'upper-limit',
	UNDEFINED : 'undefined',
	OPERAND : 'operand',
	MAP : 'map',
	VARIABLE_NAME: 'variable-name',
	LIST_ITEM_VALUE : 'list-item-value',
	DOMAIN : 'domain',
	CONTAINER : 'container',
	LOCALIZED_TEXT_MAP : 'localized-text-map',
	VALUE : 'value',
	ACTIVATE_CONDITION_CONTAINER : 'activate-condition-container',
	NAME : 'name',
	NAME_TEXT_MAP : 'name-text-map',
	TYPE : 'type',
	VALUE_DOMAIN : 'value-domain',
	LIST_MAP : 'list-map',
	SWEEP_DOMAIN : 'sweep-domain',
	ORDER : 'order',
	DESCRIPTION_MAP : 'description-map',
	DIMENSION : 'dimension',
	BRACE_CHAR : 'brace-char',
	DELIMITER : 'delimiter',
	SAMPLE : 'sample',
	SPACE : 'space',
	VALUE_DELIMITER : 'value-delimiter',
	LINE_DELIMITER : 'line-delimiter',
	COMMENT_CHAR : 'comment-char',
	VECTOR_FORM : 'vector-form',
	LINE_FORM : 'line-form',
	AVAILABLE_LANGUAGE_IDS : 'available-language-ids',
	DEFAULT_LANGUAGE_ID : 'default-language-id',
	VARIABLE_MAP : 'variable-map',
	UNIT : 'unit',
	SWEEP : 'sweep',
	SWEEPABLE : 'sweepable',
	SWEEP_SLICE : 'sweep-slice',
	TARGET_LANGUAGE_ID : 'target-language-id',
	getBraceTypes : function (){
		var types = [];
		types.push(this.BRACE_TYPE_SQUARE);
		types.push(this.BRACE_TYPE_SQUARE_SPACE);
		types.push(this.BRACE_TYPE_ROUND);
		types.push(this.BRACE_TYPE_ROUND_SPACE);
	},
	getVariableTypes : function (){
		var types = [];
		types.push(this.VARIABLE_TYPE_NUMERIC);
		types.push(this.VARIABLE_TYPE_VECTOR);
		types.push(this.VARIABLE_TYPE_STRING);
		types.push(this.VARIABLE_TYPE_GROUP);
		types.push(this.VARIABLE_TYPE_COMMENT);
	}
};

var InputdeckErrors = {
	LOWER_LIMIT_INVALID : "lower limit invalid",
	UPPER_LIMIT_INVALID : "upper limit invalid",
	OPERAND_INVALID : "operand invalid",
	TYPE_MISMATCH:"type mismatch"
};


function Domain() {
	this.getLowerLimit = function() {
		return this[InputdeckConstants.LOWER_LIMIT];
	};
	this.setLowerLimit = function(limit) {
		if (isNaN(limit))		return InputdeckErrors.LOWER_LIMIT_INVALID;
		var upperLimit = this.getUpperLimit();
		if( typeof upperLimit == InputdeckConstants.UNDEFINED || upperLimit > limit )
			this[InputdeckConstants.LOWER_LIMIT] = limit;
		else	return InputdeckErrors.LOWER_LIMIT_INVALID;
		return true;
	};
	this.getUpperLimit = function() {
		return this[InputdeckConstants.UPPER_LIMIT];
	};
	this.setUpperLimit = function(limit) {
		if (isNaN(limit))		return InputdeckErrors.UPPER_LIMIT_INVALID;
		var lowerLimit = this.getLowerLimit();
		if( typeof lowerLimit == InputdeckConstants.UNDEFINED || lowerLimit < limit )	
			this[InputdeckConstants.UPPER_LIMIT] = limit;
		else	return InputdeckErrors.UPPER_LIMIT_INVALID;
		return true;
	};
	this.getOperand = function() {
		return this[InputdeckConstants.OPERAND];
	};
	this.setOperand = function(operand) {
		if (operand.length != 2 || !/[=<][=>]/.test(operand))
			return InputdeckErrors.OPERAND_INVALID;
		this[InputdeckConstants.OPERAND] = operand;
		return true;
	};
	this.containLowerLimit = function(flag){
		var operand = this.getOperand();
		var text;
		if( typeof operand == InputdeckConstants.UNDEFINED )
			text = [];
		else
			text = operand.split('');
		if(flag == true)
			text[0] = '=';
		else
			text[0] = '<';
		this.setOperand(text.join(''));
		return true;
	};
	this.containUpperLimit = function(flag){
		var operand = this.getOperand();
		var text;
		if( typeof operand == InputdeckConstants.UNDEFINED )
			text = [];
		else
			text = operand.split('');
		if(flag == true)
			text[1] = '=';
		else
			text[1] = '>';
		this.setOperand(text.join(''));
		return true;
	};
	this.isLowerLimitContained = function(){
		var operand = this.getOperand();
		if( operand.charAt(0) == '=')	return true;
		else if( operand.charAt(0) == '<')	return false;
		else	return void(0); 
	};
	this.isUpperLimitContained = function(){
		var operand = this.getOperand();
		if( operand.charAt(1) == '=')	return true;
		else if( operand.charAt(1) == '>')	return false;
		else	return void(0); 
	};
	this.setValues = function(lowerLimit, upperLimit, operand) {
		var result = this.setLowerLimit(lowerLimit);
		if( result != true )	return result;
		result = this.setUpperLimit(upperLimit);
		if( result != true )	return result;
		result = this.setOperand(operand);
		if( result != true )	return result;
		return result;
	};
	this.isInDomain = function(value){
		var lowerLimitContained = this.isLowerLimitContained();
		var upperLimitContained = this.isUpperLimitContained();
		var lowerLimit = this.getLowerLimit();
		var upperLimit = this.getUpperLimit();
		
		if(  lowerLimitContained && upperLimitContained){
			if( value >= lowerLimit && value <= upperLimit )	return true;
		}
		else if( !lowerLimitContained && upperLimitContained ){
			if( value > lowerLimit && value <= upperLimit )	return true;
		}
		else if( lowerLimitContained && !upperLimitContained ){
			if( value >= lowerLimit && value < upperLimit )	return true;
		}
		else if( !lowerLimitContained && !upperLimitContained ){
			if( value > lowerLimit && value < upperLimit )	return true;
		}
		
		return false;
	};
	this.setData = function(jsonData){
		var lowerLimit = json[InputdeckConstants.LOWER_LIMIT];
		if( typeof lowerLimit == InputdeckConstants.UNDEFINED ){
			return InputdeckErrors.LOWER_LIMIT_INVALID;
		}
		var upperLimit = json[InputdeckConstants.UPPER_LIMIT];
		if( typeof upperLimit == InputdeckConstants.UNDEFINED ){
			return InputdeckErrors.UPPER_LIMIT_INVALID;
		}
		var operand = json[InputdeckConstants.OPERAND];
		if( typeof operand == InputdeckConstants.UNDEFINED ){
			return InputdeckErrors.OPERAND_INVALID;
		}
		
		var result =  this.setValues(lowerLimit, upperLimit, operand);
		
		return result;
	};
	this.clean = function(){
		delete this[InputdeckConstants.LOWER_LIMIT];
		delete this[InputdeckConstants.UPPER_LIMIT];
		delete this[InputdeckConstants.OPERAND];
	};
};

function LocalizedTextMap() {
	this.getMap = function() {
		var map = this[InputdeckConstants.MAP];
		if (typeof map == InputdeckConstants.UNDEFINED) {
			map = {};
			this[InputdeckConstants.MAP] = map;
		}
		return map;
	};
	this.setMap = function(map) {
		this[InputdeckConstants.MAP] = map;
	};
	this.getLocalizedText = function(languageId) {
		var map = this.getMap();
		return map[languageId];
	};
	this.addLocalizedText = function(languageId, text) {
		var map = this.getMap();
		map[languageId] = text;
	};
	this.removeLocalizedText = function(languageId) {
		var map = this.getMap();
		delete map[languageId];
	};
	this.getLocalizedXML = function(availableLanguageIds, defaultLanguageId) {
		var xml = '<?xml version=\'1.0\' encoding=\'UTF-8\'?>';
		xml += '<root available-locales=\'';
		xml += availableLanguageIds.join() + '\' ';
		xml += 'default-locale=\'' + defaultLanguageId + '\'>';

		var map = this.getMap();
		var keys = Object.keys(map);
		keys.forEach(function(item, index) {
			var value = map[item];
			if( typeof value != InputdeckConstants.UNDEFINED)
				xml += '<display language-id=\'' + item + '\'>' + value
					+ '</display>';
		});

		xml += '</root>';

		return xml;
	};
	this.clean = function(){
		this[InputdeckConstants.MAP] = {};
	};
	this.setData = function(jsonData){
		this.setMap(jsonData);
	};
};

function ActivateCondition() {
	this.getType = function(){
		return this[InputdeckConstants.TYPE];
	};
	this.setType = function(type){
		this[InputdeckConstants.TYPE] = type
	};
	this.getVariableName = function() {
		return this[InputdeckConstants.VARIABLE_NAME];
	};
	this.setVariableName = function(name) {
		this[InputdeckConstants.VARIABLE_NAME] = name;
	};
	this.getListItemValue = function() {
		return this[InputdeckConstants.LIST_ITEM_VALUE];
	};
	this.setListItemValue = function(value) {
		this[InputdeckConstants.LIST_ITEM_VALUE] = value;
	};
	this.getDomain = function(){
		var domain = this[InputdeckConstants.DOMAIN];
		if( typeof domain == InputdeckConstants.UNDEFINED ){
			domain = new Domain();
			this[InputdeckConstants.DOMAIN] = domain;
		} 
		return domain;
	};
	this.setDomain = function(domain){
		if( this.getType() === InputdeckConstants.VARIABLE_TYPE_NUMERIC)
			this[InputdeckConstants.DOMAIN] = domain;
		else
			return InputdeckErrors.TYPE_MISMATCH;
	};
	this.getDomainLowerLimit = function() {
		var domain = this.getDomain();
		return domain.getLowerLimit();
	};
	this.setDomainLowerLimit = function(limit) {
		var domain = this.getDomain();
		return domain.setLowerLimit(limit);
	};
	this.getDomainUpperLimit = function() {
		var domain = this.getDomain();
		return domain.getUpperLimit();
	};
	this.setDomainUpperLimit = function(limit) {
		var domain = this.getDomain();
		return domain.setUpperLimit(limit);
	};
	this.getDomainOperand = function() {
		var domain = this.getDomain();
		return domain.getOperand();
	};
	this.setDomainOperand = function(operand) {
		var domain = this.getDomain();
		return domain.setOperand(operand);
	};
	this.containDomainLowerLimit = function(){
		var domain = this.getDomain();
		return domain.containLowerLimit();
	};
	this.containDomainUpperLimit = function(){
		var domain = this.getDomain();
		return domain.containUpperLimit();
	};
	this.isDomainLowerLimitContained = function(){
		var domain = this.getDomain();
		return domain.isLowerLimitContained();
	};
	this.isDomainUpperLimitContained = function(){
		var domain = this.getDomain();
		return domain.isUpperLimitContained();
	};
	this.isInDomain = function(value){
		var domain = this.getDomain();
		return domain.isInDomain(value);
	};
	this.setNumericCondition = function(variableName, lower, upper, operand) {
		this.setType(InputdeckConstants.VARIABLE_TYPE_NUMERIC);
		var domain = this.getDomain();
		this.setVariableName(variableName);
		return domain.setValues(lower, upper, operand);
	};
	this.setListItemCondition = function(variableName, listItemValue) {
		this.setType(InputdeckConstants.VARIABLE_TYPE_LIST);
		this.setVariableName(variableName);
		this.setListItemValue(listItemValue);
	};
	this.setGroupCondition = function(variableName) {
		this.setType(InputdeckConstants.VARIABLE_TYPE_GROUP);
		this.setVariableName(variableName);
	};
	this.setData = function(jsonData){
		this.setVariableName(jsonData[InputdeckConstants.VARIABLE_NAME]);
		this.setListItemValue(jsonData[InputdeckConstants.LIST_ITEM_VALUE]);
		this.getDomain().setData(jsonData[InputdeckConstants.DOMAIN]);
	};
};

function ActivateConditionContainer() {
	this.getContainer = function() {
		var container = this[InputdeckConstants.CONTAINER];
		if (typeof container == InputdeckConstants.UNDEFINED) {
			container = [];
			this[InputdeckConstants.CONTAINER] = container;
		}
		return container;
	};
	this.setContainer = function(container) {
		this[InputdeckConstants.CONTAINER] = container;
	};
	this.addActivateCondition = function(condition) {
		var container = this.getContainer();
		container.push(condition);
	};
	this.addListItemActivateCondition = function(variableName, listItemValue) {
		var condition = new ActivateCondition();
		condition.setListItemCondition(variableName, listItemValue);

		this.addActivateCondition(condition);
	};
	this.addNumericActivateCondition = function(variableName, min, max, operand) {
		var condition = new ActivateCondition();
		condition.setNumericCondition(variableName, min, max, operand);

		this.addActivateCondition(condition);
	};
	this.addGroupActivateCondition = function(variableName) {
		var condition = new ActivateCondition();
		condition.setGroupCondition(variableName);

		this.addActivateCondition(condition);
	};
	this.removeActivateConditions = function(variableName) {
		var container = this.getContainer();
		var updatedContainer = [];
		var reval = false;

		container.forEach(function(condition, index) {
			if (variableName != condition.getVariableName())
				updatedContainer.push(condition);
			else
				reval = true;
		});

		this.setContainer(updatedContainer);
		return reval;
	};
	this.removeListItemActivateCondition = function(variableName, listItemValue) {
		var container = this.getContainer();
		var updatedContainer = [];
		var reval = false;

		container.forEach(function(condition, index) {
			if (variableName != condition.getVariableName()
					|| listItemValue != condition.getListItemValue())
				updatedContainer.push(condition);
			else
				reval = true;
		});

		this.setContainer(updatedContainer);
		return reval;
	};
	this.removeNumericActivateCondition = function(variableName, min, max, operand) {
		var container = this.getContainer();
		var updatedContainer = [];
		var reval = false;

		container.forEach(function(condition, index) {
			if (variableName != condition.getVariableName()
					|| min != condition.getDomainLowerLimit() 
					|| max != condition.getDomainUpperLimit()
					|| operand != condition.getDomainOperand())
				updatedContainer.push(condition);
			else
				reval = true;
		});

		this.setContainer(updatedContainer);
		return reval;
	};
	this.setData = function(jsonData){
		var dataContainer = jsonData[InputdeckConstants.CONTAINER];
		var that = this;
		dataContainer.forEach(function(conditionData, index){
			var condition = new ActivateCondition();
			condition.setData(conditionData);
			that.addActivateCondition(condition);
		});
	};
};

function ListItem() {
	this.getLocalizedTextMap = function() {
		var map = this[InputdeckConstants.LOCALIZED_TEXT_MAP];
		if (typeof map == InputdeckConstants.UNDEFINED) {
			map = new LocalizedTextMap();
			this[InputdeckConstants.LOCALIZED_TEXT_MAP] = map;
		}

		return map;
	};
	this.setLocalizedTextMap = function(map) {
		this[InputdeckConstants.LOCALIZED_TEXT_MAP] = map;
	};
	this.getItemValue = function() {
		return this[InputdeckConstants.VALUE];
	};
	this.setItemValue = function(value) {
		this[InputdeckConstants.VALUE] = value;
	};
	this.getLocalizedText = function(languageId) {
		var map = this.getLocalizedTextMap();
		return map.getLocalizedText(languageId);
	};
	this.addLocalizedText = function(languageId, text) {
		var map = this.getLocalizedTextMap();
		map.addLocalizedText(languageId, text);
	};
	this.removeLocalizedText = function(languageId) {
		var map = this.getLocalizedTextMap();
		map.removeLocalizedText(languageId);
	};
	this.getLocalizedXML = function(availableLanguageIds, defalutLanguageId) {
		var map = this.getLocalizedTextMap();
		return map.getLocalizedXML(availableLanguageIds, defalutLanguageId);
	};
	this.cleanLocalizedTextMap = function(){
		var map = this.getLocalizedTextMap();
		map.clean();
	};
	this.getActivateConditionContainer = function() {
		var container = this[InputdeckConstants.ACTIVATE_CONDITION_CONTAINER];
		if (typeof container == InputdeckConstants.UNDEFINED) {
			container = new ActivateConditionContainer();
			this[InputdeckConstants.ACTIVATE_CONDITION_CONTAINER] = container;
		}
		return container;
	};
	this.setActivateConditionContainer = function(container) {
		this[InputdeckConstants.ACTIVATE_CONDITION_CONTAINER] = container;
	};
	this.getActivateConditions = function() {
		var container = this.getActivateConditionContainer();
		return container.getContainer();
	};
	this.setActivateConditions = function(conditions) {
		var container = this.getActivateConditionContainer();
		container.setContainer(conditions);
	};
	this.addActivateCondition = function(condition) {
		var container = this.getActivateConditionContainer();
		container.addActivateCondition(condition);
	};
	this.addListItemActivateCondition = function(variableName, listItemValue) {
		var container = this.getActivateConditionContainer();
		container.addListItemActivateCondition(variableName, listItemValue);
	};
	this.addNumericActivateCondition = function(variableName, min, max, operand) {
		var container = this.getActivateConditionContainer();
		container.addNumericActivateCondition(variableName, min, max, operand);
	};
	this.removeActivateConditionsByVariableName = function(variableName) {
		var container = this.getActivateConditionContainer();
		container.removeActivateConditionsByVariableName(variableName);
	};
	this.removeListItemActivateCondition = function(variableName, listItemValue) {
		var container = this.getActivateConditionContainer();
		container.removeListItemActivateCondition(variableName, listItemValue);
	};
	this.removeNumericActivateCondition = function(variableName, min, max, operand) {
		var container = this.getActivateConditionContainer();
		container.removeNumericActivateCondition(variableName, min, max, operand);
	};
	this.setData = function(jsonData){
		this.setValue(jsonData[InputdeckConstants.VALUE]);
		this.getLocalizedTextMap().setData(jsonData[InputdeckConstants.LOCALIZED_TEXT_MAP]);
		this.getActivateConditionContainer().setData(jsonData[InputdeckConstants.ACTIVATE_CONDITION_CONTAINER]);
	};
};

function ListMap() {
	this.getListMap = function() {
		var map = this[InputdeckConstants.MAP];
		if (typeof map == InputdeckConstants.UNDEFINED) {
			map = {};
			this[InputdeckConstants.MAP] = map;
		}

		return map;
	};
	this.setListMap = function(map) {
		this[InputdeckConstants.MAP] = map;
	};
	this.getListItem = function(itemValue) {
		var map = this.getListMap();
		return map[itemValue];
	};
	this.addListItem = function(itemValue, listItem) {
		var map = this.getListMap();
		map[itemValue] = listItem;
	};
	this.getLocalizedListItemText = function(itemValue, languageId) {
		var listItem = this.getListItem(itemValue);
		return listItem.getLocalizedText(languageId);
	};
	this.getLocalizedListItemXML = function(itemValue, availablLanguageIds,
			defaultLanguageId) {
		var listItem = this.getListItem(itemValue);
		return listItem.getLocalizedXML(availablLanguageIds, defaultLanguageId);
	};
	this.getLocalizedListMap = function(languageId) {
		var listMap = {};
		var map = this.getListMap();
		var keys = Object.keys(map);
		
		var that = this;
		keys.forEach(function(item, index) {
			var listItem = that.getListItem(item);
			listMap[item] = listItem.getLocalizedText(languageId);
		});

		return listMap;
	};
	this.getListXMLMap = function(availablLanguageIds, defaultLanguageId) {
		var listXML = {};
		var map = this.getListMap();
		var keys = Object.keys(map);
		
		var that = this;
		keys.forEach(function(item, index) {
			var listItem = that.getListItem(item);
			listXML[item] = listItem.getLocalizedXML(availableLanguageIds,
					defaultLanguageId);
		});

		return listXml;
	};
	this.removeListItem = function(itemValue) {
		var map = this.getListMap();
		delete map[itemValue];
	};
	
	this.setData = function(jsonData){
		var dataMap = jsonData[InputdeckConstants.MAP];
		var keys = Object.keys(dataMap);
		
		var that = this;
		keys.forEach(function(key, index){
			var listItemData = dataMap[key];
			var listItem = new ListItem();
			listItem.setData(listItemData);
			that.addListItem(key, listItem);
		});
	};
};

function Sweep(){
	this.isSweepable = function(){
		var sweepable = this[InputdeckConstants.SWEEPABLE];
		if( typeof sweepable == InputdeckConstants.UNDEFINED )
			return false;
		return sweepable;
	};
	this.setSweepable = function(flag){
		this[InputdeckConstants.SWEEPABLE] = flag;
	};
	this.getSlice = function(){
		return this[InputdeckConstants.SWEEP_SLICE];
	};
	this.setSlice = function(slice){
		this[InputdeckConstants.SWEEP_SLICE] = slice;
	};
	this.getDomain = function(){
		var domain = this[InputdeckConstants.DOMAIN];
		if( typeof domain == InputdeckConstants.UNDEFINED ){
			domain = new Domain();
			this[InputdeckConstants.DOMAIN] = domain;
		}
		return domain;
	};
	this.setDomain = function(domain){
		this[InputdeckConstants.DOMAIN];
	};
	this.getDomainLowerLimit = function() {
		var domain = this.getDomain();
		return domain.getLowerLimit();
	};
	this.setDomainLowerLimit = function(limit) {
		var domain = this.getDomain();
		return domain.setLowerLimit(limit);
	};
	this.getDomainUpperLimit = function() {
		var domain = this.getDomain();
		return domain.getUpperLimit();
	};
	this.setDomainUpperLimit = function(limit) {
		var domain = this.getDomain();
		return domain.setUpperLimit(limit);
	};
	this.getDomainOperand = function() {
		var domain = this.getDomain();
		return domain.getOperand();
	};
	this.setDomainOperand = function(operand) {
		var domain = this.getDomain();
		return domain.setOperand(operand);
	};
	this.containDomainLowerLimit = function(flag){
		var domain = this.getDomain();
		return domain.containLowerLimit(flag);
	};
	this.containDomainUpperLimit = function(flag){
		var domain = this.getDomain();
		return domain.containUpperLimit(flag);
	};
	this.isDomainLowerLimitContained = function(){
		var domain = this.getDomain();
		return domain.isLowerLimitContained(); 
	};
	this.isDomainUpperLimitContained = function(){
		var domain = this.getDomain();
		return domain.isUpperLimitContained(); 
	};
	this.setDomainValues = function(lowerLimit, upperLimit, operand) {
		var domain = this.getDomain();
		return domain.setValues(lowerLimit, upperLimit, operand);
	};
	this.isInDomain = function(value){
		var domain = this.getDomain();
		return domain.isInDomain(value);
	};
};

function Variable() {
	this.getName = function() {
		return this[InputdeckConstants.NAME];
	};
	this.setName = function(name) {
		if(this.veryfyName(name) == true) 
			this[InputdeckConstants.NAME] = name;
	};
	this.getNameTextMap = function() {
		var map = this[InputdeckConstants.NAME_TEXT_MAP];
		if (typeof map == InputdeckConstants.UNDEFINED) {
			map = new LocalizedTextMap();
			this[InputdeckConstants.NAME_TEXT_MAP] = map;
		}
		return map;
	};
	this.setNameTextMap = function(map) {
		this[InputdeckConstants.NAME_TEXT_MAP] = map;
	};
	this.getNameLocalizedText = function(languageId) {
		var map = this.getNameTextMap();
		return map.getLocalizedText(languageId);
	};
	this.addNameLocalizedText = function(languageId, text) {
		var map = this.getNameTextMap();
		map.addLocalizedText(languageId, text);
	};
	this.removeNameLocalizedText = function(languageId) {
		var map = this.getNameTextMap();
		map.removeLocalizedText(languageId);
	};
	this.getNameLocalizedXML = function(availableLanguageIds, defaultLanguageId) {
		var map = this.getNameTextMap();
		return map.getLocalizedXML(availableLanguageIds, defaultLanguageId);
	};
	this.cleanNameText = function(){
		var map = this.getNameTextMap();
		map.clean();
	};
	this.getType = function() {
		return this[InputdeckConstants.TYPE];
	};
	this.setType = function(type) {
		this[InputdeckConstants.TYPE] = type;
	};
	this.getActivateConditionContainer = function() {
		var container = this[InputdeckConstants.ACTIVATE_CONDITION_CONTAINER];
		if (typeof container == InputdeckConstants.UNDEFINED) {
			container = new ActivateConditionContainer();
			this[InputdeckConstants.ACTIVATE_CONDITION_CONTAINER] = container;
		}

		return container;
	};
	this.setActivateConditionContainer = function(container) {
		this[InputdeckConstants.ACTIVATE_CONDITION_CONTAINER] = container;
	};
	this.addActivateCondition = function(condition) {
		var container = this.getActivateConditionContainer();
		container.addActivateCondition(condition);
	};
	this.addListItemActivateCondition = function(variableName, listItemValue) {
		var container = this.getActivateConditionContainer();
		container.addListItemActivateCondition(variableName, listItemValue);
	};
	this.addNumericActivateCondition = function(variableName, min, max, operand) {
		var container = this.getActivateConditionContainer();
		container.addNumericActivateCondition(variableName, min, max, operand);
	};
	this.addGroupActivateCondition = function(variableName) {
		var container = this.getActivateConditionContainer();
		container.addGroupActivateCondition(variableName);
	};
	this.removeActivateConditions = function(variableName) {
		var container = this.getActivateConditionContainer();
		return container.removeActivateConditions(variableName);
	};
	this.removeListItemActivateCondition = function(variableName, listItemValue) {
		var container = this.getActivateConditionContainer();
		return container.removeListItemActivateCondition(variableName, listItemValue);
	};
	this.removeNumericActivateCondition = function(variableName, min, max, operand) {
		var container = this.getActivateConditionContainer();
		return container.removeNumericActivateCondition(variableName, min, max, operand);
	};
	this.getGroupActivateConditions = function(){
		var container = this.getActivateConditionContainer();
		var groupConditionContainer = [];
		container.forEach(function(activateCondition){
			if(activateCondition.getType() === InputdeckConstants.VARIABLE_TYPE_GROUP)
				groupConditionContainer.push(activateCondition);
		});
		return groupConditionContainer;
	};
	this.getListItemActivateConditions = function(){
		var container = this.getActivateConditionContainer();
		var listItemConditionContainer = [];
		container.forEach(function(activateCondition){
			if(activateCondition.getType() === InputdeckConstants.VARIABLE_TYPE_LIST)
				listItemConditionContainer.push(activateCondition);
		});
		return listItemConditionContainer;
	};
	this.getNumericActivateConditions = function(){
		var container = this.getActivateConditionContainer();
		var numericConditionContainer = [];
		container.forEach(function(activateCondition){
			if(activateCondition.getType() === InputdeckConstants.VARIABLE_TYPE_NUMERIC)
				numericConditionContainer.push(activateCondition);
		});
		return numericConditionContainer;
	};
	this.getValue = function() {
		return this[InputdeckConstants.VALUE];
	};
	this.setValue = function(value) {
		this[InputdeckConstants.VALUE] = value;
	};
	this.getUnit = function(){
		return this[InputdeckConstants.UNIT];
	};
	this.setUnit = function(unit){
		this[InputdeckConstants.UNIT] = unit;
	};
	this.getValueDomain = function() {
		var domain = this[InputdeckConstants.VALUE_DOMAIN];
		if (typeof domain == InputdeckConstants.UNDEFINED) {
			domain = new Domain();
			this[InputdeckConstants.VALUE_DOMAIN] = domain;
		}

		return domain;
	};
	this.setValueDomain = function(domain) {
		this[InputdeckConstants.VALUE_DOMAIN] = domain;
	};
	this.getValueDomainLowerLimit = function() {
		var domain = this.getValueDomain();
		return domain.getLowerLimit();
	};
	this.setValueDomainLowerLimit = function(limit) {
		var domain = this.getValueDomain();
		return domain.setLowerLimit(limit);
	};
	this.getValueDomainUpperLimit = function() {
		var domain = this.getValueDomain();
		return domain.getUpperLimit();
	};
	this.setValueDomainUpperLimit = function(limit) {
		var domain = this.getValueDomain();
		return domain.setUpperLimit(limit);
	};
	this.getValueDomainOperand = function() {
		var domain = this.getValueDomain();
		return domain.getOperand();
	};
	this.setValueDomainOperand = function(operand) {
		var domain = this.getValueDomain();
		return domain.setOperand(operand);
	};
	this.containValueDomainLowerLimit = function(flag){
		var domain = this.getValueDomain();
		return domain.containLowerLimit(flag);
	};
	this.containValueDomainUpperLimit = function(flag){
		var domain = this.getValueDomain();
		return domain.containUpperLimit(flag);
	};
	this.isValueDomainLowerLimitContained = function(){
		var domain = this.getValueDomain();
		return domain.isLowerLimitContained(); 
	};
	this.isValueDomainUpperLimitContained = function(){
		var domain = this.getValueDomain();
		return domain.isUpperLimitContained(); 
	};
	this.setValueDomainValues = function(lowerLimit, upperLimit, operand) {
		var domain = this.getValueDomain();
		return domain.setValues(lowerLimit, upperLimit, operand);
	};
	this.isInValueDomain = function(value){
		var domain = this.getValueDomain();
		return domain.isInDomain(value);
	};
	this.getListMap = function() {
		var map = this[InputdeckConstants.LIST_MAP];
		if (typeof map == InputdeckConstants.UNDEFINED) {
			map = new ListMap();
			this[InputdeckConstants.LIST_MAP] = map;
		}
		return map;
	};
	this.setListMap = function(map) {
		this[InputdeckConstants.LIST_MAP] = map;
	};
	this.getListItem = function(itemValue) {
		var map = this.getListMap();
		return map.getListItem(itemValue);
	};
	this.addListItem = function(itemValue, listItem) {
		var map = this.getListMap();
		map.addListItem(itemValue, listItem);
	};
	this.getLocalizedListItemText = function(itemValue, languageId) {
		var map = this.getListMap();
		return map.getLocalizedListItemText(itemValue, languageId);
	};
	this.getLocalizedListItemXML = function(itemValue, availablLanguageIds,
			defaultLanguageId) {
		var map = this.getListMap();
		return map.getLocalizedListItemXML(itemValue, availablLanguageIds, defaultLanguageId);
	};
	this.getLocalizedListMap = function(languageId) {
		var map = this.getListMap();
		return map.getLocalizedListMap(languageId);
	};
	this.getListXMLMap = function(availablLanguageIds, defaultLanguageId) {
		var map = this.getListMap();
		return map.getListXMLMap(availablLanguageIds, defaultLanguageId);
	};
	this.removeListItem = function(itemValue) {
		var map = this.getListMap();
		map.removeListItem(itemValue);
	};
	this.getSweep = function(){
		var sweep = this[InputdeckConstants.SWEEP];
		if( typeof sweep == InputdeckConstants.UNDEFINED ){
			sweep = new Sweep();
			this[InputdeckConstants.SWEEP] = sweep;
		}
		return sweep;
	};
	this.setSweep = function(sweep){
		this[InputdeckConstants.SWEEP] = sweep;
	};
	this.isSweepable = function(){
		var sweep = this.getSweep();
		return sweep.isSweepable();
	};
	this.setSweepable = function(flag){
		var sweep = this.getSweep();
		sweep.setSweepable(flag);
	};
	this.getSweepSlice = function(){
		var sweep = this.getSweep();
		return sweep.getSlice();
	};
	this.setSweepSlice = function(slice){
		var sweep = this.getSweep();
		sweep.setSlice(slice) ;
	};
	this.getSweepDomainLowerLimit = function() {
		var sweep = this.getSweep();
		return sweep.getDomainLowerLimit();
	};
	this.setSweepDomainLowerLimit = function(limit) {
		var sweep = this.getSweep();
		return sweep.setDomainLowerLimit(limit);
	};
	this.getSweepDomainUpperLimit = function() {
		var sweep = this.getSweep();
		return sweep.getDomainUpperLimit();
	};
	this.setSweepDomainUpperLimit = function(limit) {
		var sweep = this.getSweep();
		return sweep.setDomainUpperLimit(limit);
	};
	this.getSweepDomainOperand = function() {
		var sweep = this.getSweep();
		return sweep.getDomainOperand();
	};
	this.setSweepDomainOperand = function(operand) {
		var sweep = this.getSweep();
		return sweep.setDomainOperand(operand);
	};
	this.containSweepDomainLowerLimit = function(flag){
		var sweep = this.getSweep();
		return sweep.containDomainLowerLimit(flag);
	};
	this.containSweepDomainUpperLimit = function(flag){
		var sweep = this.getSweep();
		return sweep.containDomainUpperLimit(flag);
	};
	this.isSweepDomainLowerLimitContained = function(){
		var sweep = this.getSweep();
		return sweep.isDomainLowerLimitContained(); 
	};
	this.isSweepDomainUpperLimitContained = function(){
		var sweep = this.getSweep();
		return sweep.isDomainUpperLimitContained(); 
	};
	this.setSweepDomainValues = function(lowerLimit, upperLimit, operand) {
		var sweep = this.getSweep();
		return sweep.setDomainValues(lowerLimit, upperLimit, operand);
	};
	this.isInSweepDomain = function(value){
		var sweep = this.getSweep();
		return sweep.isInDomain(value);
	};
	this.getOrder = function() {
		return this[InputdeckConstants.ORDER];
	};
	this.setOrder = function(order){
		this[InputdeckConstants.ORDER] = order;
	};
	this.getDescriptionMap = function() {
		var map = this[InputdeckConstants.DESCRIPTION_MAP];
		if (typeof map == InputdeckConstants.UNDEFINED) {
			map = new LocalizedTextMap();
			this[InputdeckConstants.DESCRIPTION_MAP] = map;
		}

		return map;
	};
	this.setDescriptionMap = function(map) {
		this[InputdeckConstants.DESCRIPTION_MAP] = map;
	};
	this.getLocalizedDescription = function(languageId) {
		var map = this.getDescriptionMap();
		return map.getLocalizedText(languageId);
	};
	this.addLocalizedDescription = function(languageId, text) {
		var map = this.getDescriptionMap();
		map.addLocalizedText(languageId, text);
	};
	this.removeLocalizedDescription = function(languageId) {
		var map = this.getDescriptionMap();
		map.removeLocalizedText(languageId);
	};
	this.getLocalizedDescriptionXML = function(availableLanguageIds, defaultLanguageId) {
		var map = this.getDescriptionMap();
		return map.getLocalizedXML(availableLanguageIds, defaultLanguageId);
	};
	this.cleanDescription = function(){
		var map = this.getDescriptionMap();
		map.clean();
	};
	this.getDimension = function() {
		return this[InputdeckConstants.DIMENSION];
	};
	this.setDimension = function(dimension) {
		this[InputdeckConstants.DIMENSION] = dimension;
	};
	this.verifyName = function(name){
		if(/[a-zA-Z\\_]/.test(name.charAt(0)) == false) return false;
		if(/[^a-zA-Z0-9\\_]/.test(name))	return false;
		return true;
	};
	this.setData = function (jsonData){
		this.setName(jsonData[InputdeckConstants.NAME]);
		this.getNameTextMap().setData(jsonData[InputdeckConstants.NAME_TEXT_MAP]);
		this.setType(jsonData[InputdeckConstants.TYPE]);
		this.getActivateConditionContainer().setData(jsonData[InputdeckConstants.ACTIVATE_CONDITION_CONTAINER]);
		this.setValue(jsonData[InputdeckConstants.VALUE]);
		this.getValueDomain().setData(jsonData[InputdeckConstants.VALUE_DOMAIN]);
		this.getListMap().setData(jsonData[InputdeckConstants.LIST_MAP]);
		this.getSweepDomain().setData(jsonData[InputdeckConstants.SWEEP_DOMAIN]);
		this.setOrder(jsonData[InputdeckConstants.ORDER]);
		this.getDescriptionMap().setData(jsonData[InputdeckConstants.DESCRIPTION_MAP]);
		this.setDimension(jsonData[InputdeckConstants.DIMENSION]);
	};
};

function VariableMap() {
	this.getMap = function() {
		var map = this[InputdeckConstants.MAP];
		if (typeof map == InputdeckConstants.UNDEFINED) {
			map = {};
			this[InputdeckConstants.MAP] = map;
		}

		return map;
	};
	this.setMap = function(map) {
		this[InputdeckConstants.MAP] = map;
	};
	this.getVariable = function(variableName) {
		var map = this.getMap();
		return map[variableName];
	};
	this.addVariable = function(variable) {
		if(this.verifyVariableName(variable.getName()) == false)	return null;
		
		var map = this.getMap();
		map[variable.getName()] = variable;
	};
	this.removeVariable = function(variableName) {
		var map = this.getMap();
		delete map[variableName];
	};
	this.createVariable = function(variableName){
		if(this.verifyVariableName(variableName) == false)	return null;
		
		var map = this.getMap();
		var variable = new Variable();
		map[variableName] = variable;
		
		return variable;
	};
	this.getVariableNames = function(){
		var map = this.getMap();
		return Object.keys(map);
	};
	this.getVariableNamesByType = function(type){
		var map = this.getMap();
		var keys = Object.keys(map);
		var names = [];
		
		var that = this;
		keys.forEach(function(item, index){
			var variable = that.getVariable(item);
			if(variable.getType() == type){
				names.push(item);
			}
		});
		
		return names;
	};
	this.verifyVariableName = function(variableName){
		if(/[a-zA-Z\\_]/.test(variableName.charAt(0)) == false) return false;
		if(/[^a-zA-Z0-9\\_]/.test(variableName))	return false;
		
		var map = this.getMap();
		if(map.hasOwnProperty(variableName))	return false;
		
		return true;
	};
	this.setData = function(jsonData){
		var variableMapData = jsonData[InputdeckConstants.VARIABLE_MAP];
		var keys = Object.keys(variableMapData);
		var that = this;
		keys.forEach(function(key, index){
			var variable = new Variable();
			variable.setData(variableMapData[key]);
			that.addVariable(variable);
		});
	};
};

function VectorForm() {
	this.setValues = function(braceChar, delimiter, sample) {
		this[InputdeckConstants.BRACE_CHAR] = braceChar;
		this[InputdeckConstants.DELIMITER] = delimiter;
		this[InputdeckConstants.SAMPLE] = sample;
	};
	this.getBraceChar = function() {
		return this[InputdeckConstants.BRACE_CHAR];
	};
	this.setBraceChar = function(braceChar) {
		this[InputdeckConstants.BRACE_CHAR] = braceChar;
	};
	this.getDelimiter = function() {
		return this[InputdeckConstants.DELIMITER];
	};
	this.setDelimiter = function(delimiter) {
		this[InputdeckConstants.DELIMITER] = delimiter;
	};
	this.getSpace = function() {
		return this[InputdeckConstants.SPACE];
	};
	this.setSpace = function(space) {
		this[InputdeckConstants.SPACE] = space;
	};
	this.getSample = function() {
		return this[InputdeckConstants.SAMPLE];
	};
	this.setSample = function(sample) {
		this[InputdeckConstants.SAMPLE] = sample;
	};
	this.setData = function(jsonData){
		this.setValues(
			jsonData[InputdeckConstants.BRACE_CHAR],
			jsonData[InputdeckConstants.DELIMITER],
			jsonData[InputdeckConstants.SAMPLE]
		);
		
		this.setSpace(jsonData[InputdeckConstants.SPACE]);
	};
};

function LineForm() {
	this.setValues = function(valueDelimiter, lineDelimiter, commentChar) {
		this[InputdeckConstants.VALUE_DELIMITER] = valueDelimiter;
		this[InputdeckConstants.LINE_DELIMITER] = lineDelimiter;
		this[InputdeckConstants.COMMENT_CHAR] = commentChar;
	};
	this.getValueDelimiter = function() {
		return this[InputdeckConstants.VALUE_DELIMITER];
	};
	this.setValueDelimiter = function(delimiter) {
		this[InputdeckConstants.VALUE_DELIMITER] = delimiter;
	};
	this.getLineDelimiter = function() {
		return this[InputdeckConstants.LINE_DELIMITER];
	};
	this.setLineDelimiter = function(delimiter) {
		this[InputdeckConstants.LINE_DELIMITER] = delimiter;
	};
	this.getCommentChar = function() {
		return this[InputdeckConstants.COMMENT_CHAR];
	};
	this.setCommentChar = function(commentChar) {
		this[InputdeckConstants.COMMENT_CHAR] = commentChar;
	};
	this.isSpace = function() {
		var space = this[InputdeckConstants.SPACE];
		if( typeof space == InputdeckConstants.UNDEFINED )	return false;
		return space; 
	};
	this.setSpace = function(space) {
		this[InputdeckConstants.SPACE] = space;
	};
	this.setData = function(jsonData){
		this.setValues(
				jsonData[InputdeckConstants.VALUE_DELIMITER], 
				jsonData[InputdeckConstants.LINE_DELIMITER], 
				jsonData[InputdeckConstants.COMMENT_CHAR]);
		this.setSpace(jsonData[InputdeckConstants.SPACE]);
	};
};

function InputdeckForm() {
	this.getVectorForm = function() {
		var vectorForm = this[InputdeckConstants.VECTOR_FORM];
		if (typeof vectorForm == InputdeckConstants.UNDEFINED) {
			vectorForm = new VectorForm();
			this[InputdeckConstants.VECTOR_FORM] = vectorForm;
		}
		return vectorForm;
	};
	this.setVectorForm = function(vectorForm) {
		this[InputdeckConstants.VECTOR_FORM] = vectorForm;
	};
	this.setVectorFormValues = function(braceChar, delimiter, sample) {
		var vectorForm = this.getVectorForm();
		vectorForm.setValues(braceChar, delimiter, sample);
	};
	this.getVectorFormBraceChar = function() {
		var vectorForm = this.getVectorForm();
		return vectorForm.getBraceChar();
	};
	this.setVectorFormBraceChar = function(braceChar) {
		var vectorForm = this.getVectorForm();
		vectorForm.setBraceChar(braceChar);
	};
	this.getVectorFormDelimiter = function() {
		var vectorForm = this.getVectorForm();
		return vectorForm.getDelimiter();
	};
	this.setVectorFormDelimiter = function(delimiter) {
		var vectorForm = this.getVectorForm();
		vectorForm.setDelimiter(delimiter);
	};
	this.getVectorFormSpace = function() {
		var vectorForm = this.getVectorForm();
		return vectorForm.getSpace();
	};
	this.setVectorFormSpace = function(space) {
		var vectorForm = this.getVectorForm();
		vectorForm.setSpace(space);
	};
	this.getVectorFormSample = function() {
		var vectorForm = this.getVectorForm();
		return vectorForm.getSample();
	};
	this.setVectorFormSample = function(sample) {
		var vectorForm = this.getVectorForm();
		vectorForm.setSample(sample);
	};
	this.getLineForm = function() {
		var lineForm = this[InputdeckConstants.LINE_FORM];
		if (typeof lineForm == InputdeckConstants.UNDEFINED) {
			lineForm = new LineForm();
			this[InputdeckConstants.LINE_FORM] = lineForm;
		}

		return lineForm;
	};
	this.setLineForm = function(lineForm) {
		this[InputdeckConstants.LINE_FORM] = lineForm;
	};
	this.setLineFormValues = function(valueDelimiter, lineDelimiter, commentChar) {
		var lineForm = this.getLineForm();
		lineForm.setValues(valueDelimiter, lineDelimiter, commentChar);
	};
	this.getLineFormValueDelimiter = function() {
		var form = this.getLineForm();
		return form.getValueDelimiter();
	};
	this.setLineFormValueDelimiter = function(delimiter) {
		var form = this.getLineForm();
		form.setValueDelimiter(delimiter);
	};
	this.getLineFormLineDelimiter = function() {
		var form = this.getLineForm();
		return form.getLineDelimiter();
	};
	this.setLineFormLineDelimiter = function(delimiter) {
		var form = this.getLineForm();
		form.setLineDelimiter(delimiter);
	};
	this.getLineFormCommentChar = function() {
		var form = this.getLineForm();
		return form.getCommentchar();
	};
	this.setLineFormCommentChar = function(commentChar) {
		var form = this.getLineForm();
		form.setCommentChar(commentChar);
	};
	this.isLineFormSpace = function() {
		var form = this.getLineForm();
		return form.isSpace(); 
	};
	this.setLineFormSpace = function(space) {
		var form = this.getLineForm();
		form.setSpace(space);
	};
	this.getAvailableLanguageIds = function() {
		var array = this[InputdeckConstants.AVAILABLE_LANGUAGE_IDS];
		if( typeof array == InputdeckConstants.UNDEFINED){
			array = [];
			this[InputdeckConstants.AVAILABLE_LANGUAGE_IDS] = array;
		}
		return array;
	};
	this.setAvailableLanguageIds = function(languageIds) {
		this[InputdeckConstants.AVAILABLE_LANGUAGE_IDS] = languageIds;
	};
	this.getDefaultLanguageId = function() {
		return this[InputdeckConstants.DEFAULT_LANGUAGE_ID];
	};
	this.setDefaultLanguageId = function(languageId) {
		this[InputdeckConstants.DEFAULT_LANGUAGE_ID] = languageId;
	};
	this.getVariableMap = function() {
		var map = this[InputdeckConstants.VARIABLE_MAP];
		if (typeof map == InputdeckConstants.UNDEFINED) {
			map = new VariableMap();
			this[InputdeckConstants.VARIABLE_MAP] = map;
		}
		return map;
	};
	this.setVariableMap = function(map) {
		this[InputdeckConstants.VARIABLE_MAP] = map;
	};
	this.getVariable = function(variableName) {
		var map = this.getVariableMap();
		return map.getVariable(variableName);
	};
	this.addVariable = function(variable) {
		var map = this.getVariableMap();
		map.addVariable(variable);;
	};
	this.removeVariable = function(variableName) {
		var map = this.getVariableMap();
		map.removeVariable(variableName);
	};
	this.createVariable = function(variableName){
		var map = this.getVariableMap();
		return map.createVariable(variableName);
	};
	this.cloneVariable = function(variable, count){
		var jsonData = JSON.stringify(variable);
		var prefix = variable.getName();
		var index = 1;
		var clones = [];
		var clone;
		for(; index<=count; index++){
			clone = new Variable();
			clone.setData(jsonData);
			var name = prefix + "_" + i;
			if( clone.verifyName(name) ){
				clone.setName(name);
				clones.push(clone);
			}
		}
		
		if( index == count ){
			for( index = 0; index < count; index++ ){
				this.addVariable(clones[index]);
			}
		}
		else
			return null;
		
		return clones;
	};
	this.cloneVariableGroup = function(variable){
		if( variable.getType() != InputdeckConstants.VARIABLE_TYPE_GROUP )
			return null;
		
		var that = this;
		var newGroup = this.cloneVariable(variable, 1);
		if( newGroup == null )	return null;
		
		newGroup.setActivateConditionContainer([]);
		var orgConditionContainer = variable.getActivateConditionContainer();
		orgConditionContainer.forEach(function(condition, index){
			var orgVarName = condition.getVariableName();
			var orgVar = that.getVariable(orgVarname);
			var varClones = that.cloneVariable(orgVar, 1);
			var activateCondition = new ActivateCondition();
			activateCondition.setVariableName(varClones[0]);
			newGrowp.addActivateCondition(activateCondition);
		});
		
		return newGroup;
	};
	this.getVariableNames = function(){
		var map = this.getVariableMap();
		return map.getVariableNames();
	};
	this.getVariableNamesByType = function(type){
		var map = this.getVariableMap();
		return map.getVariableNamesByType(type);
	};
	this.setData = function(jsonData){
		this.getVectorForm().setData(jsonData[InputdeckConstants.VECTOR_FORM]);
		this.getLineForm().setData(jsonData[InputdeckConstants.LINE_FORM]);
		this.setAvailableLanguageIds(jsonData[InputdeckConstants.AVAILABLE_LANGUAGE_IDS]);
		this.setDefaultLanguageId(jsonData[InputdeckConstants.DEFAULT_LANGUAGE_ID]);
		
		var variableMapData = jsonData[InputdeckConstants.VARIABLE_MAP];
		this.getVariableMap().setData(variableMapData);
	};
};
