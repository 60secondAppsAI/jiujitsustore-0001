import http from "../http-common"; 

class StoreService {
  getAllStores(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/store/stores`, searchDTO);
  }

  get(storeId) {
    return this.getRequest(`/store/${storeId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/store?field=${matchData}`, null);
  }

  addStore(data) {
    return http.post("/store/addStore", data);
  }

  update(data) {
  	return http.post("/store/updateStore", data);
  }
  
  uploadImage(data,storeId) {
  	return http.postForm("/store/uploadImage/"+storeId, data);
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

export default new StoreService();
