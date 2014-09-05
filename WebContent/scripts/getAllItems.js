var holdData;

var storeValues;

$(document)
		.ready(
				function() {

					 $("#selectedItems").hide();

					$
							.ajax({
								url : "http://localhost:8080/PointOfSale/pos/ItemController/getAllItems",
								type : 'GET',
								dataType : 'json',

								success : function(data) {

									$("#charttable").find("tr:gt(0)").remove();

									var table1 = $("#charttable");
									var chk = $("#chk");

									$
											.each(
													data,
													function(index, value) {
														holdData = data;
														var sId = (value.id)
																.toString();

														var rowNew = $("<tr><td></td><td></td><td></td><td><input type=checkbox value="
																+ sId
																+ " name = name ></td></tr>");

														rowNew
																.children()
																.eq(0)
																.text(
																		value['itemName']); // first
														// column

														rowNew
																.children()
																.eq(1)
																.text(
																		value['quantity']);// second
														// column

														rowNew
																.children()
																.eq(2)
																.text(
																		value['price']);// second
														// column

														rowNew.appendTo(table1);

													});

								},
								error : function(data, status, er) {
									alert(data + " : " + er + " : " + status);
								}
							});

				});


