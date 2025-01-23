import http from "../http-common"; 

class OrderItemService {
  getAllOrderItems(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/orderItem/orderItems`, searchDTO);
  }

  get(orderItemId) {
    return this.getRequest(`/orderItem/${orderItemId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/orderItem?field=${matchData}`, null);
  }

  addOrderItem(data) {
    return http.post("/orderItem/addOrderItem", data);
  }

  update(data) {
  	return http.post("/orderItem/updateOrderItem", data);
  }
  
  uploadImage(data,orderItemId) {
  	return http.postForm("/orderItem/uploadImage/"+orderItemId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new OrderItemService();
