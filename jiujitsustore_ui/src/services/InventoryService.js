import http from "../http-common"; 

class InventoryService {
  getAllInventorys(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/inventory/inventorys`, searchDTO);
  }

  get(inventoryId) {
    return this.getRequest(`/inventory/${inventoryId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/inventory?field=${matchData}`, null);
  }

  addInventory(data) {
    return http.post("/inventory/addInventory", data);
  }

  update(data) {
  	return http.post("/inventory/updateInventory", data);
  }
  
  uploadImage(data,inventoryId) {
  	return http.postForm("/inventory/uploadImage/"+inventoryId, data);
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

export default new InventoryService();
