import http from "../http-common"; 

class SupplierService {
  getAllSuppliers(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/supplier/suppliers`, searchDTO);
  }

  get(supplierId) {
    return this.getRequest(`/supplier/${supplierId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/supplier?field=${matchData}`, null);
  }

  addSupplier(data) {
    return http.post("/supplier/addSupplier", data);
  }

  update(data) {
  	return http.post("/supplier/updateSupplier", data);
  }
  
  uploadImage(data,supplierId) {
  	return http.postForm("/supplier/uploadImage/"+supplierId, data);
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

export default new SupplierService();
