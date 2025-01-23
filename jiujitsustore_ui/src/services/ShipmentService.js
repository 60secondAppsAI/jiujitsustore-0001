import http from "../http-common"; 

class ShipmentService {
  getAllShipments(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/shipment/shipments`, searchDTO);
  }

  get(shipmentId) {
    return this.getRequest(`/shipment/${shipmentId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/shipment?field=${matchData}`, null);
  }

  addShipment(data) {
    return http.post("/shipment/addShipment", data);
  }

  update(data) {
  	return http.post("/shipment/updateShipment", data);
  }
  
  uploadImage(data,shipmentId) {
  	return http.postForm("/shipment/uploadImage/"+shipmentId, data);
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

export default new ShipmentService();
