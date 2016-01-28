public with sharing class OnlinePurchaseController {

    public List<Product2> productList{get;set;}
    public List<PurchaseOrderLineItem__c> productsToPurchase{get;set;}
    public Set<ID> productsToPurchaseItem{get;set;}
    public String productId{get;set;}
    public Integer quantity{get;set;}
    public Product2 selectedProduct{get;set;}
    public Product2 productNew{get;set;}
    public PurchaseOrder__c order{get;set;}
 	public List<PurchaseOrder__c> ListOfOrder{get;set;}    
    public boolean purchaseOrderLineItemsdisplayPopUp {get; set;}     
    public boolean purchaseOrderdisplayPopUp {get; set;}  
    public boolean informationDisplayPopUp {get; set;} 
    public boolean OrderDisplayPopUp{get;set;}
    
    
    public OnlinePurchaseController(ApexPages.StandardController controller){
        // set all the boolean variables to false to not show the blocks on page
        purchaseOrderLineItemsdisplayPopUp = false;
        purchaseOrderdisplayPopUp = false;
        informationDisplayPopUp = false;
        OrderDisplayPopUp=false;
        getProductList();
        productsToPurchase = new List<PurchaseOrderLineItem__c>();
        ListOfOrder=new List<PurchaseOrder__c>();
        productsToPurchaseItem = new Set<ID>();
        // to get the id of the product when called from the product page
        if((Product2)controller.getRecord()!=null){
           productNew=(Product2)controller.getRecord();
            productId=productNew.Id;
        }
        
    }
    
    //to select all the products
    public Void getProductList(){
        string Query = 'SELECT id,name,price__c FROM Product2';
        productList = Database.query(Query);
    }
    
    public Void addToCart(){
		// to get the list of all order has done by the user
        ListOfOrder=[Select id,Name,Name__c,Address__c,Phone__c,Total_Payment__c,Order_Status__c from PurchaseOrder__c where Order_Status__c=true];
    
        //to get the list of order who are not paid 
        List<PurchaseOrder__c> orderList=[Select id,Name,Name__c,Address__c,Phone__c,Total_Payment__c from PurchaseOrder__c where Order_Status__c=false];
        if(orderList.size()>0){
            order=orderList.get(0);     
        }else{
            order=new PurchaseOrder__c(Name='OrderNew');
            insert order;
        }
        
        // the product which you have added to cart
        productsToPurchase= [Select id,name,Product__c,Quantity__c,ESmartPack__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLineItem__c where OrderId__c=:order.Id];
        for(PurchaseOrderLineItem__c item:productsToPurchase){
            //set of productId in cart
            productsToPurchaseItem.add(item.Product__c);
        }
        
        System.debug('In add to cart');
           purchaseOrderLineItemsdisplayPopUp = true;
        //if the cart contain this product then increase its quantity in order in cart
        if(productsToPurchaseItem.contains(productId)){
             OrderDisplayPopUp = true;
                for(PurchaseOrderLineItem__c productInLineItem : productsToPurchase){
                    if(productInLineItem.Product__c == productId){
                        productInLineItem.Quantity__c = ++productInLineItem.Quantity__c;
                        upsert productInLineItem;
                    }
                }   
        }
        //adding product to the cart if doesn't have this product.
        else if(productId!=null){              
            OrderDisplayPopUp = true;
            selectedProduct = [Select id,name,price__C from Product2 where id=:productId];
            PurchaseOrderLineItem__c lineItem = new PurchaseOrderLineItem__c();
            lineItem.Name = selectedProduct.Name;
            lineItem.Product__c = selectedProduct.id;
            lineItem.Quantity__c = 1;
            lineItem.UnitPrice__c = selectedProduct.price__C; 
            lineItem.OrderId__c=order.Id;
            insert lineItem;
            ID lineItemId = lineItem.id;
            PurchaseOrderLineItem__c p = [Select id,name,Product__c,Quantity__c,ESmartPack__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLineItem__c where id=:lineItemId];
            productsToPurchase.add(p);
            productsToPurchaseItem.add(p.Product__c);
        }
     }    
   // to remove the order from the cart.
     public Void removeFromCart(){
         purchaseOrderLineItemsdisplayPopUp = true;
         PurchaseOrderLineItem__c productInCart = [Select id, name,Quantity__c,ESmartPack__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLineItem__c where id=:productId];
         Integer index = 0;
         for(PurchaseOrderLineItem__c purchaseOrder : productsToPurchase){
             if(purchaseOrder.Id == productInCart.Id){
                 break;
             }
               index++;
         }
         productsToPurchaseItem.remove(productsToPurchase.get(index).Product__c);
         productsToPurchase.remove(index);
         Delete productInCart;
    }
    
    //to enter user detail for payment
    public void pay(){
        for(PurchaseOrderLineItem__c purchaseOrder : productsToPurchase){
           System.debug('\nnew  '+ purchaseOrder.Quantity__c + '   '+purchaseOrder.ESmartPack__c);
           
         }
       informationDisplayPopUp = true;
        upsert productsToPurchase;
    }
    // to confirm order .
    public void confirm(){
        order.Order_Status__c=true;
        double price=0;
        double quantity =0;
        for(PurchaseOrderLineItem__c purchaseOrder : productsToPurchase){
           price= price+purchaseOrder.TotalPrice__c;
          quantity = quantity+purchaseOrder.Quantity__c;
        }
        if(order.Total_Payment__c!=null){
        order.Total_Payment__c=order.Total_Payment__c+price;
        }else{
            order.Total_Payment__c=price;
        }
        
        system.debug(order);
        upsert order;
        system.debug(order);
        ListOfOrder=[Select id,Name,Name__c,Address__c,Phone__c,Total_Payment__c,Order_Status__c from PurchaseOrder__c];
        OrderDisplayPopUp = true;
        system.debug(ListOfOrder);
        
		productsToPurchase.clear();
        productsToPurchaseItem.clear();
        purchaseOrderLineItemsdisplayPopUp = false;
        purchaseOrderdisplayPopUp = false;
        informationDisplayPopUp = false;
    }
}