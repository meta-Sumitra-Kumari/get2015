trigger OpportunityClosed on Opportunity (after update) {

  if (Trigger.IsAfter && Trigger.IsUpdate) 
    {
      Set<Id> setOpporutnityId = new Set<Id>();
      for (Opportunity objOpportunity:Trigger.New) 
              {
          if (objOpportunity.Custom_Status__c != null && objOpportunity.Custom_Status__c == 'Reset' && objOpportunity.Custom_Status__c != Trigger.OldMap.get(objOpportunity.Id).Custom_Status__c) 
                      {
              setOpporutnityId.Add(objOpportunity.id);
               
            }
        }
    }
}