trigger CountUpdate on Student__c (after insert,after delete) {
 List<Class__C> cl = [Select Number_Of_Students__c,My_Count__c from class__C];
       for(Class__C c : cl){
           c.My_Count__c=c.Number_Of_Students__c;
       }
       update cl;
    Map<String,Integer> classMap = new Map<String,Integer>();
   if(Trigger.isInsert){
      
       
       for(Student__C student : Trigger.NEW){
           if(classMap.containsKey(student.class__c)){
               Integer newValue = classMap.get(student.class__c);
               classMap.put(student.class__c, ++newValue);
                System.debug('in first for');
           }
           else{
               System.debug(student.class__c);
               classMap.put(student.class__c, 1);
           }
       }
       List<Class__C> classList = [Select id, My_Count__c from Class__C where id IN :classMap.keySet()];
     
       for(Class__C classToUpdate : classList){
           classToUpdate.My_Count__c += classMap.get(classToUpdate.Id);
          
       }
       update classList;
   }
    if(Trigger.isDelete){
        
       
       for(Student__C student : Trigger.OLD){
           if(classMap.containsKey(student.class__c)){
               Integer newValue = classMap.get(student.class__c);
               classMap.put(student.class__c, ++newValue);
                System.debug('in first for');
           }
           else{
               System.debug(student.class__c);
               classMap.put(student.class__c, 1);
           }
       }
       List<Class__C> classList = [Select id, My_Count__c from Class__C where id IN :classMap.keySet()];
     
       for(Class__C classToUpdate : classList){
           classToUpdate.My_Count__c -= classMap.get(classToUpdate.Id);
          
       }
       update classList;
    }
   
}