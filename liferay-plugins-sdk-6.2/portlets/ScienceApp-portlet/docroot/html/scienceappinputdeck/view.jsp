<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.util.LocalizationUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/js/inputdeck_form.jspf" %>
<portlet:defineObjects />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/hashmap.js"></script>
<style>
	input[type="text"]{
	  margin: 0 5px;
	  width: 100px;
	  font-family: sans-serif;
	  font-size: 18px;
	  appearance: none;
	  box-shadow: none;
	  border-radius: none;
	}
	input[type="text"]:focus {
	  outline: none;
	}
	.mainContent{
		width: 100%;
		padding: 0px;
	}
	.mainContent h3{
		background-color: #555;
		padding-left: 20px;
		color: #FFF;
	}
	.mainContent input[type="button"]{
		width: 300px;
		line-height: 20px;
	}
	.submitDiv{
		text-align: center;
		width: 100%;
	}
	.jsonFormDiv{
		padding: 0px 10px;
	}
</style>
<div class="mainContent">
	<h3>InputDeck Form</h3>
	<div id="<portlet:namespace/>formDiv" style="display:none"></div>
	<div id="<portlet:namespace/>variableDiv">
		<form id="<portlet:namespace/>inputdeckForm">
			<table id="<portlet:namespace/>variableTable">
				<thead>
					<tr>
						<th>Variable Name</th>
						<th>Value</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</form>
	</div>
	<div class="submitDiv">
		<input type="button" id="<portlet:namespace/>submitBtn" value="Generate JSON&FILE" />
	</div>
	<div class="resultDiv">
		<div style="width:50%; float:left;padding:0px;">
			<h3>JSON View</h3>
			<div id="<portlet:namespace/>inputJSON" class="jsonFormDiv"></div>
		</div>
		<div style="width:50%; float:right;padding:0px;">
			<h3>File View</h3>
			<div id="<portlet:namespace/>inputFILE"  class="jsonFormDiv"></div>
		</div>
	</div>
</div>
<script>
	var defaultLanguage = '<%= request.getAttribute("defaultLanguage")%>';
	var availableLanguages =  '<%= request.getAttribute("availableLanguages")%>';

	var originalInputDeckForm = null;
	var userInputDeckForm = null;
	var variableMap;
	
	// 폼 생성 후, condition에 따른 event listener를 add할 form id를 가지는 map
	var eventMap = new HashMap();
	// map에 파라미터 정보는 처음만 등록
	var isFirstCheck = true;
	
	//vectorForm 정보
	var braceDisplayArray = ["[", "]"];
	var isVectorSpace = true;
	var vectorDelimiter = ",";
	
	//lineForm 정보
	commentChar = null;
	isLineSpace = null;
	valueDelimiter = null;
	lineDelimiter = null;
		
	function createInputDeckFormatJSON()
	{
		var inputdeckForm = new InputdeckForm();
		var variableMap = inputdeckForm.getVariableMap();
		
		inputdeckForm.setDefaultLanguageId( defaultLanguage );
		inputdeckForm.setAvailableLanguageIds( availableLanguages );
		
		var vectorForm = inputdeckForm.getVectorForm();
		vectorForm.setBraceChar( InputdeckConstants.BRACE_TYPE_SQUARE_SPACE );
		vectorForm.setSample("P=[1,2,3];");
		vectorForm.setSpace( true );
		vectorForm.setDelimiter(",");
		
		var lineForm = inputdeckForm.getLineForm();
		lineForm.setSpace(true);
		lineForm.setValues("=",";","#");
		
		// Variable Sample Numeric01
		var numVariable = variableMap.createVariable("varNum01");
		numVariable.setType( InputdeckConstants.VARIABLE_TYPE_NUMERIC );
		numVariable.setValue( "3" );
		//numVariable.setSweepable(false);
		
		var localizedTextMap = numVariable.getNameTextMap();
		localizedTextMap.addLocalizedText("en_US","Number Param01");
		localizedTextMap.addLocalizedText("ko_KR","숫자 변수01");
		
		var activateCondition = numVariable.getActivateConditionContainer();
		activateCondition.addNumericActivateCondition("varNum03", 1, 9, "=>");
		activateCondition.addListItemActivateCondition("varList01", 3);
		
		var valueDomain = numVariable.getValueDomain();
		valueDomain.setValues(1,5,"==");
		
		//var sweepDomain = numVariable.getSweepDomain();
		//sweepDomain.setValues(2,3,"<>");
		
		var descriptionMap = new LocalizedTextMap();
		descriptionMap.addLocalizedText("en_US","Number Description01");
		descriptionMap.addLocalizedText("ko_KR","숫자 설명01");
		numVariable.setDescriptionMap(descriptionMap);
		
		// Variable Sample Numeric02
		var numVariable = variableMap.createVariable("varNum02");
		numVariable.setType( InputdeckConstants.VARIABLE_TYPE_NUMERIC );
		numVariable.setValue( "1" );
		
		//set domain
		numVariable.setValueDomainValues(2,10,"<>");
		
		//set sweep
		numVariable.setSweepable(true);
		numVariable.setSweepDomainValues(3,9,"<=");
		
		var localizedTextMap = numVariable.getNameTextMap();
		localizedTextMap.addLocalizedText("en_US","Number Param02");
		localizedTextMap.addLocalizedText("ko_KR","숫자 변수02");
		
		var activateCondition = numVariable.getActivateConditionContainer();
		activateCondition.addNumericActivateCondition("varNum03", 3, 7, "<>");
		
		//var descriptionMap = numVariable.getDescriptionMap();
		var descriptionMap = new LocalizedTextMap();
		descriptionMap.addLocalizedText("en_US","Number Description02");
		descriptionMap.addLocalizedText("ko_KR","숫자 설명02");
		numVariable.setDescriptionMap(descriptionMap);
		
		// Variable Sample Numeric03
		var numVariable = variableMap.createVariable("varNum03");
		numVariable.setType( InputdeckConstants.VARIABLE_TYPE_NUMERIC );
		numVariable.setValue( 2 );
		
		//set domain
		numVariable.setValueDomainValues(1,12,"<>");
		
		//set sweep
		numVariable.setSweepable(false);
		numVariable.setSweepDomainValues(4,9,"==");
		
		var localizedTextMap = numVariable.getNameTextMap();
		localizedTextMap.addLocalizedText("en_US","Number Param03");
		localizedTextMap.addLocalizedText("ko_KR","숫자 변수03");
		
		// varNum03은 activeCondition의 메인 변수임으로 condition을 가질 수 없다. 1단계
		//var activateCondition = numVariable.getActivateConditionContainer();
		//activateCondition.addNumericActivateCondition("numberCondition", 4, 7, "<>");
		//activateCondition.addListItemActivateCondition("listCondition", 1);
		
		//var descriptionMap = numVariable.getDescriptionMap();
		var descriptionMap = new LocalizedTextMap();
		descriptionMap.addLocalizedText("en_US","Number Description03");
		descriptionMap.addLocalizedText("ko_KR","숫자 설명03");
		numVariable.setDescriptionMap(descriptionMap);
		
		// Variable Sample String
		var stringVariable = variableMap.createVariable("varString");
		stringVariable.setType( InputdeckConstants.VARIABLE_TYPE_STRING );
		stringVariable.setValue( "Default Value" );

		var localizedTextMap = stringVariable.getNameTextMap();
		localizedTextMap.addLocalizedText("en_US","String Param");
		localizedTextMap.addLocalizedText("ko_KR","문자열 변수");
		
		var descriptionMap = new LocalizedTextMap();
		descriptionMap.addLocalizedText("en_US","Number Description");
		descriptionMap.addLocalizedText("ko_KR","문자열 설명");
		stringVariable.setDescriptionMap(descriptionMap);
		
		// Variable Sample Vector
		var vectorVariable = variableMap.createVariable("varVector");
		vectorVariable.setType( InputdeckConstants.VARIABLE_TYPE_VECTOR );
		vectorVariable.setDimension( "4" );
		vectorVariable.setValue("[ 1 , 4 , 7 , 8 ]");

		var localizedTextMap = vectorVariable.getNameTextMap();
		localizedTextMap.addLocalizedText("en_US","Vector Param");
		localizedTextMap.addLocalizedText("ko_KR","벡터 변수");
		
		var descriptionMap = new LocalizedTextMap();
		descriptionMap.addLocalizedText("en_US","Vetor Description");
		descriptionMap.addLocalizedText("ko_KR","벡터 설명");
		vectorVariable.setDescriptionMap(descriptionMap);

		// Variable Sample List01
		var listVariable = variableMap.createVariable("varList01");
		listVariable.setType( InputdeckConstants.VARIABLE_TYPE_LIST );
		listVariable.setValue(2);

		var localizedTextMap = listVariable.getNameTextMap();
		localizedTextMap.addLocalizedText("en_US","List Param01");
		localizedTextMap.addLocalizedText("ko_KR","리스트 변수01");
		
		var descriptionMap = new LocalizedTextMap();
		descriptionMap.addLocalizedText("en_US","List Description01");
		descriptionMap.addLocalizedText("ko_KR","리스트 설명01");
		listVariable.setDescriptionMap(descriptionMap);
		
		var listMap = listVariable.getListMap();		
		
		var listItem01 = new ListItem();
		listItem01.setItemValue(1);
		listItem01.addLocalizedText("en_US","list01");
		listItem01.addLocalizedText("ko_KR","리스트01");
		
		var listItem02 = new ListItem();
		listItem02.setItemValue(2);
		listItem02.addLocalizedText("en_US","list02");
		listItem02.addLocalizedText("ko_KR","리스트02");
		
		var listItem03 = new ListItem();
		listItem03.setItemValue(3);
		listItem03.addLocalizedText("en_US","list03");
		listItem03.addLocalizedText("ko_KR","리스트03");
		
		listMap.addListItem(1, listItem01);
		listMap.addListItem(2, listItem02);
		listMap.addListItem(3, listItem03);
		
		// Variable Sample List02
		var listVariable = variableMap.createVariable("varList02");
		listVariable.setType( InputdeckConstants.VARIABLE_TYPE_LIST );
		listVariable.setValue(30);

		var localizedTextMap = listVariable.getNameTextMap();
		localizedTextMap.addLocalizedText("en_US","List Param02");
		localizedTextMap.addLocalizedText("ko_KR","리스트 변수02");
		
		var descriptionMap = new LocalizedTextMap();
		descriptionMap.addLocalizedText("en_US","List Description02");
		descriptionMap.addLocalizedText("ko_KR","리스트 설명02");
		listVariable.setDescriptionMap(descriptionMap);
		
		var listMap = listVariable.getListMap();		
		
		var listItem01 = new ListItem();
		listItem01.setItemValue(5);
		listItem01.addLocalizedText("en_US","list01");
		listItem01.addLocalizedText("ko_KR","리스트01");
		
		var listItem02 = new ListItem();
		listItem02.setItemValue(62);
		listItem02.addLocalizedText("en_US","list02");
		listItem02.addLocalizedText("ko_KR","리스트02");
		
		var listItem03 = new ListItem();
		listItem03.setItemValue(4);
		listItem03.addLocalizedText("en_US","list03");
		listItem03.addLocalizedText("ko_KR","리스트03");
		
		listMap.addListItem(10, listItem01);
		listMap.addListItem(20, listItem02);
		listMap.addListItem(30, listItem03);
		
		return inputdeckForm;
	}
	
	function createInputDeckEditor( inputdeckForm )
	{
		variableMap = inputdeckForm.getVariableMap();
		
		//Add LineForm
		var lineForm = inputdeckForm.getLineForm();
		commentChar = lineForm.getCommentChar();
		isLineSpace = lineForm.isSpace();
		valueDelimiter = lineForm.getValueDelimiter();
		lineDelimiter = lineForm.getLineDelimiter();
		//addLabelForm( "<h4>Line Form : " + "P" +(isLineSpace?" ":"")+valueDelimiter + (isLineSpace?" ":"")+"1234"+lineDelimiter+"<br/>Comment Char : " +commentChar+"</h4>");
		
		//Add VectorForm
		var vectorForm = inputdeckForm.getVectorForm();
		braceChar = vectorForm.getBraceChar();
		braceDisplayArray = getBraceDisplayText(braceChar);
		isVectorSpace = vectorForm.getSpace();
		vectorDelimiter = vectorForm.getDelimiter();
		
		//addLabelForm( "<h4>Vector Form : " + braceDisplayArray[0] +(isVectorSpace?" ":"")+"1"+vectorDelimiter+(isVectorSpace?" ":"") +
		//		(isVectorSpace?" ":"")+"2"+vectorDelimiter+(isVectorSpace?" ":"")+(isVectorSpace?" ":"")+"3"+(isVectorSpace?" ":"")+ braceDisplayArray[1] +"</h4>");
		
		//Add VariableMap
		var variable;
		var dimension;
		var delimiter;
		
		// String  Variable  Type Add
		
		//console.log( variableMap.getVariableNames() );
		
		var variableNames = variableMap.getVariableNames();
		for(var i=0; i<variableNames.length;i++)
		{
			var variable = variableMap.getVariable(variableNames[i]);
		
			switch( variable.getType() )
			{
				case InputdeckConstants.VARIABLE_TYPE_STRING:
					addInputTextForm( variableNames[i], variable );
					break;
				case InputdeckConstants.VARIABLE_TYPE_NUMERIC:
					// 폼자체는 무조건 생성, condition check에 따라 show/hide
					addInputNumberForm( variableNames[i], variable );
					//check ativate condition
					checkAtivateCondition( variableNames[i], variable );
					break;
				case InputdeckConstants.VARIABLE_TYPE_LIST:
					addListForm( variableNames[i], variable );
					break;
				case InputdeckConstants.VARIABLE_TYPE_VECTOR:
					addVectorForm( variableNames[i], variable, vectorDelimiter );
					break;
				case InputdeckConstants.VARIABLE_TYPE_GROUP:
					break;
					
				
			}
		}
		
		isFirstCheck = false;
		// Group  Variable  Type Add
		//var groupVariableArray = variableMap.getVariableNamesByType( InputdeckConstants.VARIABLE_TYPE_GROUP);
		
		return inputdeckForm;
	}
	
	function addLabelForm( text )
	{
		var html = $("#<portlet:namespace/>formDiv").html();
		$("#<portlet:namespace/>formDiv").html(html+ "<p>"+text+"</p>");
	}
	
	function addInputTextForm( id, variable )
	{
		$('#<portlet:namespace/>variableTable tr:last').after('<tr id="<portlet:namespace/>div_'+id+'"><td>'+variable.getNameLocalizedText( defaultLanguage )+'</td><td><input type="text" id="<portlet:namespace/>'+id+'" value="'+variable.getValue()+'" name="'+id+'" onchange="changeValueEvent( \'value\', this)" /></td><td>'+variable.getLocalizedDescription( defaultLanguage )+'</td></tr>');
	}
	
	function addInputNumberForm( id, variable)
	{
		var name = variable.getNameLocalizedText( defaultLanguage );
		var value = variable.getValue();
		var lowerLimit = variable.getValueDomainLowerLimit();
		var upperLimit =variable.getValueDomainUpperLimit();
		var lowerSweep =variable.getSweepDomainLowerLimit();
		var upperSweep =variable.getSweepDomainUpperLimit();
		var opSweep = variable.getSweepDomainOperand();
		var desc = variable.getLocalizedDescription( defaultLanguage );
		var inputHtml = '<tr id="<portlet:namespace/>div_'+id+'" >';
		
		if( variable.isSweepable() )
		{
			inputHtml +='<td>'+name+'&nbsp;<input type="checkbox" id="<portlet:namespace/>'+id+'_check" name="<portlet:namespace/>'+id+'"onchange="changeSweepable(this);" checked/></td>'
			+'<td><span id="<portlet:namespace/>'+id+'_sweep_on">Step : <input type="text" id="<portlet:namespace/>'+id+'_step" name="'+id+'"value="'+value+'" onchange="changeValueEvent( \'step\', this)"/>'
			+'<input type="hidden" id="<portlet:namespace/>'+id+'_op" value="'+opSweep+'" name="'+id+'" />'
			+'Min : <input type="text" id="<portlet:namespace/>'+id+'_min" value="'+lowerSweep+'" name="'+id+'" onchange="changeValueEvent( \'lowerSweep\', this)"/>'
			+'Max : <input type="text" id="<portlet:namespace/>'+id+'_max" value="'+upperSweep+'" name="'+id+'" onchange="changeValueEvent( \'upperSweep\', this)"/></span>'
			+'<span id="<portlet:namespace/>'+id+'_sweep_off" style="display:none"><input type="text" id="<portlet:namespace/>'+id+'" name="'+id+'"value="'+value+'" onchange="changeValueEvent( \'value\', this)"/> (min :'+lowerLimit+', max : '+upperLimit+')</span></td>';
		}
		else
		{
			inputHtml += '<td>'+name+'</td><td><input type="text" id="<portlet:namespace/>'+id+'" name="'+id+'"value="'+value+'" onchange="checkAtivationEvent(this)"/> (min :'+lowerLimit+', max : '+upperLimit+')</td>';
		}

		inputHtml += '<td>'+desc+'</td></tr>';
		
		$('#<portlet:namespace/>variableTable tr:last').after(inputHtml);
	}
	
	function addVectorForm( id , variable, delimiter )
	{
		var value = variable.getValue();
		value = changeVectorToValue( value );
		
		var valueArr = value.split( delimiter );
		var inputHtml = '<tr id="<portlet:namespace/>div_'+id+'_vector"><td>'+variable.getNameLocalizedText( defaultLanguage )+'</td><td>';
		
		for(var i=0; i<variable.getDimension();i++)
		{
			inputHtml += '<input type="text" id="<portlet:namespace/>'+id+'_'+i+'" value="'+trim(valueArr[i])+'" name="'+id+'_'+i+'" onchange="changeValueEvent( \'vector\', this)"/>';			
		}
		inputHtml += '</td><td>'+variable.getLocalizedDescription( defaultLanguage )+'</td></tr>';
		$('#<portlet:namespace/>variableTable tr:last').after( inputHtml );
	}
	
	function addListForm( id, variable )
	{
		var listHtml = '<tr  id="<portlet:namespace/>div_'+id+'"><td>'+variable.getNameLocalizedText( defaultLanguage )+'</td><td><select id="<portlet:namespace/>'+id+'" name="'+id+'"onchange="checkAtivationEvent(this)">';
		var listMap = variable.getLocalizedListMap(defaultLanguage);
		for ( val in listMap)
		{
			listHtml += '<option value="'+val+'" '+ (variable.getValue()==val?'selected':'') + '>'+listMap[val]+'</option>';	
		}
		
		listHtml +='</select></td><td>' +variable.getLocalizedDescription( defaultLanguage )+'</td></tr>';
		$('#<portlet:namespace/>variableTable tr:last').after( listHtml );
	}
	
	function trim( str )
	{
		return str.replace(/(^\s*)|(\s*$)/gi, "");	
	}
	
	function getBraceDisplayText( braceChar )
	{
		var array = [];
		
		switch(braceChar)
		{
			case InputdeckConstants.BRACE_TYPE_SQUARE:
				array[0]="[";
				array[1]="]";
				break;
			case InputdeckConstants.BRACE_TYPE_SQUARE_SPACE:
				array[0]="[ ";
				array[1]=" ]";
				break;
			case InputdeckConstants.BRACE_TYPE_ROUND:
				array[0]="(";
				array[1]=")";
				break;
			case InputdeckConstants.BRACE_TYPE_ROUND_SPACE:
				array[0]="( ";
				array[1]=" )";
				break;
			default:
				array[0]="[";
				array[1]="]";
				break;
		}
		return array;
	}
	
	function checkAtivateCondition( id, variable )
	{
		var container = variable.getActivateConditionContainer().getContainer();
		var result = true;
		
		container.forEach(function(condition, index) {
			var targetVariable = variableMap.getVariable(condition.getVariableName());
			var targetValue = targetVariable.getValue();
			
			switch( condition.getType() )
			{
				case InputdeckConstants.VARIABLE_TYPE_NUMERIC:
					var lowerLimit = condition.getDomainLowerLimit();
					var upperLimit = condition.getDomainUpperLimit();
					var opperand = condition.getDomainOperand();
					
					//varNum03", 1, 9, "=>");
					//varNum03", 3, 7, "<>");
					//varList01", 3
					
					// min compare
					if((opperand.charAt(0) != '=' &&  targetValue <= lowerLimit) ||(opperand.charAt(0) == '=' && targetValue < lowerLimit)) 
					{
						result = false;
					}
					
					// max compare
					if((opperand.charAt(1) != '=' && upperLimit <= targetValue) || (opperand.charAt(1) == '=' && upperLimit < targetValue))
					{
						result = false;
					}
					break;
				case InputdeckConstants.VARIABLE_TYPE_LIST:
					if( condition.getListItemValue() == targetValue)
					{
						result = true;
					}
					break;
				case InputdeckConstants.VARIABLE_TYPE_GROUP:
					break;
			}

			if( isFirstCheck )
			{
				//eventMap에 target 정보를 add, 처음에만 세팅
				var conditionArray = new Array();
					
				if( typeof (eventMap.get(condition.getVariableName()))  == InputdeckConstants.UNDEFINED)
				{
					conditionArray[0] = id;
				}
				else 
				{
					conditionArray = eventMap.get(condition.getVariableName());
					conditionArray[conditionArray.length] = id;
				}
				eventMap.set(condition.getVariableName(), conditionArray);
			}
		});
		
		//condition 조건(Number of List)이 하나라도 보일경우에 show
		if(result)
			$('#<portlet:namespace/>div_'+id).css("display","");				
		else
			$('#<portlet:namespace/>div_'+id).css("display","none");
		
		return result;
	}
	
	function changeSweepable(checkboxItem)
	{
		 if($('#'+checkboxItem.id).is(':checked'))
		 {
	     	$('#'+checkboxItem.name+'_sweep_on').css("display","");
	     	$('#'+checkboxItem.name+'_sweep_off').css("display","none");
		 }
		 else
	     {
			$('#'+checkboxItem.name+'_sweep_on').css("display","none");
		    $('#'+checkboxItem.name+'_sweep_off').css("display","");
	     }
	}
	
	// 생성된 input 값의 데이터가 변경될때마다 각각 타입에 맞게 userInputDeckForm에 반영, type:value, lowerSweep, upperSweep, ,step, vector
	function changeValueEvent( type, e )
	{
		var value = e.value;
		var variable = variableMap.getVariable( e.name );
		
		if( type=='value')
		{
			variable.setValue(value);
		}
		else if( type=='lowerSweep')
		{
			validateInputText(variable.setSweepDomainLowerLimit(value));	
		}
		else if( type=='upperSweep')
		{
			validateInputText(variable.setSweepDomainUpperLimit(value));	
		}
		else if( type=='step')
		{
			variable.setSweepSlice(value);	
		}
		else if( type=='vector')
		{
			var vectorInfo = e.name.split("_");
			var id = vectorInfo[0];
			var position = vectorInfo[1];
			
			variable = variableMap.getVariable( id );
			
			var vectorValues = variable.getValue().split( vectorDelimiter );
			var newValue = "";	
			
			if( position == 0)
				vectorValues[position] = braceDisplayArray[0]+value+(isVectorSpace?" ":"");
			else if( position == (vectorValues.length-1))
				vectorValues[position] =(isVectorSpace?" ":"")+value+braceDisplayArray[1];
			else
				vectorValues[position] =(isVectorSpace?" ":"")+value+(isVectorSpace?" ":"");
			
			for(var i=0; i<vectorValues.length;i++)
			{
				newValue += vectorValues[i] + (i!= (vectorValues.length-1)?vectorDelimiter:"");
			}
			
			variable.setValue(newValue);
		}
	}

	function checkAtivationEvent( e )
	{
		var value = e.value;
		var checkIds = new Array();
		var variable = variableMap.getVariable( e.name );
		variable.setValue(value);
		
		if( typeof ( checkIds = eventMap.get(e.name))  != InputdeckConstants.UNDEFINED)
		{
			for(var i = 0; i < checkIds.length; i++)
			{
				checkAtivateCondition( checkIds[i], variableMap.getVariable( checkIds[i] ) );
			}
		}
	}
	
	function validateInputText( resultMsg)
	{
		switch(resultMsg)
		{
			case InputdeckErrors.LOWER_LIMIT_INVALID :
				alert( InputdeckErrors.LOWER_LIMIT_INVALID);
				break;
			case InputdeckErrors.UPPER_LIMIT_INVALID :
				alert( InputdeckErrors.UPPER_LIMIT_INVALID );
				break;
			case InputdeckErrors.OPERAND_INVALID :
				alert( InputdeckErrors.OPERAND_INVALID );
				break;
		}
	}
	
	function changeVectorToValue( value)
	{
		//vector의 brace와 space 치환
		value = value.replace(braceDisplayArray[0], "");
		value = value.replace(braceDisplayArray[1], "");
		value = trim(value);
		return value;
	}
	
	function showJsonScript( json)
	{
		//$("#"+div).html("<p>"+JSON.stringify(json, null, "<br/>")+"</p>");
		$("#<portlet:namespace/>inputJSON").html(JSON.stringify(json));
	};
	
	function showInputFile()
	{
		var html = "";
		var isSweep = false;
		var sweepName = "";
		var sweepStep = 0;
		var sweepMin = 0;
		var sweepMax = 0;
		var sweepOp = "";
		var name;
		var value;
		
		$.each($('input[type="text"], select', '#<portlet:namespace/>inputdeckForm'),function(k){
	    	name = $(this).attr('name');
	    	value = $(this).val();
		    if( $(this).is(':visible') && typeof(name) != InputdeckConstants.UNDEFINED)
		    {
		    	//sweep일 경우 sweep을 뺀 파라미터 셋을 만든 후, sweep 시킨다.
		    	
		    	if( 0< $(this).closest("tr").attr('id').indexOf("_vector"))
		    	{
		    		var vectorName = name.split("_");
		    		if( vectorName[1] == 0)
			    		html += "<h4>"+vectorName[0]+(isVectorSpace?" ":"")+valueDelimiter+(isVectorSpace?" ":"")+braceDisplayArray[0]+value+(isVectorSpace?" ":"")+vectorDelimiter;
					else if( typeof($(this).next(':input').attr('id')) == InputdeckConstants.UNDEFINED)
						html += (isVectorSpace?" ":"")+value+braceDisplayArray[1]+(isVectorSpace?" ":"")+lineDelimiter+"</h4>";
					else
						html += (isVectorSpace?" ":"")+value+(isVectorSpace?" ":"")+vectorDelimiter;
		    	}
		    	else if( typeof( $(this).closest("span").attr('id') ) != InputdeckConstants.UNDEFINED 
		    			&& 0< $(this).closest("span").attr('id').indexOf("sweep_on") )
	    		{
		    		if(  0< $(this).attr('id').indexOf("_step")  )
	    			{
		    			// 의미없다, 최초1회만 세팅하려고
		    			isSweep = true;
			    		sweepName = name;
		    			sweepOp = $(this).next().val()
		    			sweepStep = value;
	    			}
		    		else if( 0< $(this).attr('id').indexOf("_min") )
    				{
	    				sweepMin = value;
	    			}
	    			else if( 0< $(this).attr('id').indexOf("_max") )
    				{
	    				sweepMax = value;
	    			}
	    		}
	    		else
	    		{
	    			
		    		html += "<h4>"+name +(isLineSpace?" ":"")+valueDelimiter + (isLineSpace?" ":"")+ value+ lineDelimiter +"</h4>";
	    		}
		    }
		});
		
		// isSweep 일 경우, sweepMin, Max를 기준으로 html 파라미터 셋을 재생성한다
		if( isSweep )
		{
			var sweepValue = Number(sweepMin)+(sweepOp.charAt(0)=="="?0:1);
			var parameterSet = html;
			html = "";
			var count = 1;
			while( sweepValue <= Number(sweepMax)+(sweepOp.charAt(1)=="="?0:-1))
			{
				// sweep comment
				html += "<h5>"+commentChar +"Sweep"+count+"</h5><h4>"+sweepName +(isLineSpace?" ":"")+valueDelimiter + (isLineSpace?" ":"")+ sweepValue + lineDelimiter +"</h4>" + parameterSet+"<br/>";
				count++;
				sweepValue += Number(sweepStep);
			}
		}
		//console.log( isSweep+":"+ sweepStep +":"+ sweepMin +":"+ sweepMax +":"+sweepOp+":"+sweepOp.charAt(0));	
		$("#<portlet:namespace/>inputFILE").html(html);
	}
	
	// 숫자 타입을 가지는 인풋덱을 생성
	//var inputdeckFormJSON = createInputDeckFormatJSON();
	inputdeckForm = $.extend( {}, createInputDeckFormatJSON());
	
	// 인풋덱 에디터 생성
	userInputDeckForm =  $.extend( {}, createInputDeckEditor(inputdeckForm));
	
	$("#<portlet:namespace/>submitBtn").click(function(){
		showJsonScript(userInputDeckForm);
		showInputFile();
	})
</script>