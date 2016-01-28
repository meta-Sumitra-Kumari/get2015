trigger notallow on Contact (before insert,after update) {
   for(Contact cn : Trigger.new){
       if(cn.Subjects__c.Contains('hindi')){
           cn.addError('not allow hindi teachers to update');
       }
   }
}