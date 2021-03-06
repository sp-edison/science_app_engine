create table SciencePlatformHook_SpAffiliation (
	spAffiliationId LONG not null primary key,
	spRegionId LONG,
	spCountryId LONG,
	spAffiliationCode VARCHAR(75) null,
	spAffiliationName STRING null,
	spActive BOOLEAN
);

create table SciencePlatformHook_SpDomain (
	spDomainId LONG not null primary key,
	spDomainCode VARCHAR(75) null,
	spDomainName STRING null,
	spActive BOOLEAN
);

create table SciencePlatformHook_SpRegion (
	spRegionId LONG not null primary key,
	spCountryId LONG,
	spRegionCode VARCHAR(75) null,
	spRegionName STRING null,
	spActive BOOLEAN
);

create table SciencePlatformHook_SpUser (
	spUserId LONG not null primary key,
	spCountryId LONG,
	spRegionId LONG,
	spAffiliationId LONG,
	spUserFullName STRING null
);

create table SciencePlatformHook_SpUserDomain (
	spUserDomainId LONG not null primary key,
	spDomainId LONG,
	spUserId LONG,
	apActive BOOLEAN
);

create table SciencePlatformHook_SystemProperties (
	propertyName VARCHAR(75) not null primary key,
	propertyValue VARCHAR(75) null,
	active_ BOOLEAN
);