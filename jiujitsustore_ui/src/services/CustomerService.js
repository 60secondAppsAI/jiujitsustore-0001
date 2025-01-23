import http from "../http-common"; 

class CustomerService {
  getAllCustomers(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/customer/customers`, searchDTO);
  }

  get(customerId) {
    return this.getRequest(`/customer/${customerId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/customer?field=${matchData}`, null);
  }

  addCustomer(data) {
    return http.post("/customer/addCustomer", data);
  }

  update(data) {
  	return http.post("/customer/updateCustomer", data);
  }
  
  uploadImage(data,customerId) {
  	return http.postForm("/customer/uploadImage/"+customerId, data);
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

export default new CustomerService();
