<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <shipment-table
            v-if="shipments && shipments.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:shipments="shipments"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-shipments="getAllShipments"
             >

            </shipment-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import ShipmentTable from "@/components/ShipmentTable";
import ShipmentService from "../services/ShipmentService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    ShipmentTable,
  },
  data() {
    return {
      shipments: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllShipments(sortBy='shipmentId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await ShipmentService.getAllShipments(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.shipments.length) {
					this.shipments = response.data.shipments;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching shipments:", error);
        }
        
      } catch (error) {
        console.error("Error fetching shipment details:", error);
      }
    },
  },
  mounted() {
    this.getAllShipments();
  },
  created() {
    this.$root.$on('searchQueryForShipmentsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllShipments();
    })
  }
};
</script>
<style></style>
