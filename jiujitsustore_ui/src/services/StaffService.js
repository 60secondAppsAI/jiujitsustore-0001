import http from "../http-common"; 

class StaffService {
  getAllStaffs(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/staff/staffs`, searchDTO);
  }

  get(staffId) {
    return this.getRequest(`/staff/${staffId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/staff?field=${matchData}`, null);
  }

  addStaff(data) {
    return http.post("/staff/addStaff", data);
  }

  update(data) {
  	return http.post("/staff/updateStaff", data);
  }
  
  uploadImage(data,staffId) {
  	return http.postForm("/staff/uploadImage/"+staffId, data);
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

export default new StaffService();
