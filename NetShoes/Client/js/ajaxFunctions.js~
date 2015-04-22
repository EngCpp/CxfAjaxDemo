/**
 * @author Carlos Eduardo
 */
function AJAXServer() {

       this.SERVER_ADDRESS = 'http://localhost:8080/NetShoes/';
	 		  
        this.CEP_CALL = this.SERVER_ADDRESS + "rws/findAddress";
        this.MY_ADDRESSES_CALL   = this.SERVER_ADDRESS + "rws/getMyAddresses";
        this.SAVE_ADDRESS_CALL   = this.SERVER_ADDRESS + "rws/saveAddress";
        this.UPDATE_ADDRESS_CALL = this.SERVER_ADDRESS + "rws/updateAddress";
        this.DELETE_ADDRESS_CALL = this.SERVER_ADDRESS + "rws/deleteAddress";

	 
        this.findAddressByCep = function(cep, successCase, errorCase){ 		
	     var params = cep;
		   		   
	     this.callAsyncAjax(this.CEP_CALL, params, successCase, errorCase);				
        };
		
        this.findMyAddresses = function(successCase, errorCase){ 		
	     var params = {};
		   		   
	     this.callAsyncAjax(this.MY_ADDRESSES_CALL, params, successCase, errorCase);
        };

        this.saveAddress = function(cep, rua, numero, cidade, estado, successCase, errorCase){ 		
	     var params = {"cep": cep,
			   "rua": rua,
			   "numero": numero,
			   "cidade": cidade,
			   "estado": estado};
		   		   
	     this.callAsyncAjax(this.SAVE_ADDRESS_CALL, params, successCase, errorCase);
        };

        this.updateAddress = function(id, cep, rua, numero, cidade, estado, successCase, errorCase){ 		
	     var params = {"id" : id,
			   "cep": cep,
			   "rua": rua,
			   "numero": numero,
			   "cidade": cidade,
			   "estado": estado};
		   		   
	     this.callAsyncAjax(this.UPDATE_ADDRESS_CALL, params, successCase, errorCase);
        };

        this.deleteAddress = function(id, successCase, errorCase){ 		
	     var params = id;
		   		   
	     this.callAsyncAjax(this.DELETE_ADDRESS_CALL, params, successCase, errorCase);
        };

	/***************************************************************************************/
	
        this.callAsyncAjax = function(url, params, successCase, errorCase){

		 $.ajax({
		       type : "POST",
			url : url,
		       data : JSON.stringify(params),
		   dataType : "json",
		 contentType: "application/json",
		crossDomain : true,
		      async : true,
		      cache : false
			}).done( function(data){								
			   successCase(data);
			}).fail( function(request, err){
		  	   errorCase(err);		                         
        		});
    	};
}


