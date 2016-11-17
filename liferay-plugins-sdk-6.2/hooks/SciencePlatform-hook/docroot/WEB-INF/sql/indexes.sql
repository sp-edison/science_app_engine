create index IX_53E1FB90 on SciencePlatformHook_SpAffiliation (spCountryId);
create index IX_D0F267B4 on SciencePlatformHook_SpAffiliation (spRegionId);
create unique index IX_A9E6B65C on SciencePlatformHook_SpAffiliation (spRegionId, spAffiliationCode);

create unique index IX_2276EA6E on SciencePlatformHook_SpDomain (spDomainCode);

create index IX_F29E2E08 on SciencePlatformHook_SpRegion (spCountryId);
create unique index IX_C9861BBA on SciencePlatformHook_SpRegion (spCountryId, spRegionCode);
create index IX_BACA228 on SciencePlatformHook_SpRegion (spCountryId, spRegionId);

create index IX_3FF25947 on SciencePlatformHook_SpUserDomain (spDomainId);
create index IX_EFF9524E on SciencePlatformHook_SpUserDomain (spUserId);
create unique index IX_A9C5D33E on SciencePlatformHook_SpUserDomain (spUserId, spDomainId);