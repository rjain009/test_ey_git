sap.ui.define(["sap/ui/core/mvc/Controller",
"sap/ui/model/json/JSONModel",
"jquery.sap.global",
"anubhav/util/service",
"sap/m/MessageToast"], 
			   function(Controller, JSONModel, jQuery, service, MessageToast){
			  		return Controller.extend("anubhav.controller.Master",
			  				{
								onInit: function(){
									this.oLocalModel = new JSONModel({
										"newVendor": {
											"companyName": "",
											"contactName": "",
											"lastName": "",
											"website": "",
											"email": "",
											"status": "A",
											"regDate": new Date()
										}
									});
									this.getView().setModel(this.oLocalModel);
									var that = this;
									service.callService("/vendors","GET",null).then(
										function(data){
											that.oLocalModel.setProperty("/vendors", data);
										}
									);
								},
								onSave: function(){
									var that = this;
									service.callService("/vendor","POST", this.oLocalModel.getProperty("/newVendor")).then(
										function(data){
											MessageToast.show("Saved Successfully");
											var that2 = that;
											service.callService("/vendors","GET",null).then(
												function(data){
													that2.oLocalModel.setProperty("/vendors", data);
												}
											);
										}
									);

								}
			  				
			  				}
			  			);
			  }
);