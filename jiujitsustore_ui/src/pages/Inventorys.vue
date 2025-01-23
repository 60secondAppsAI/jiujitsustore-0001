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
            <inventory-table
            v-if="inventorys && inventorys.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:inventorys="inventorys"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-inventorys="getAllInventorys"
             >

            </inventory-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import InventoryTable from "@/components/InventoryTable";
import InventoryService from "../services/InventoryService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    InventoryTable,
  },
  data() {
    return {
      inventorys: [],
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
    async getAllInventorys(sortBy='inventoryId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await InventoryService.getAllInventorys(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.inventorys.length) {
					this.inventorys = response.data.inventorys;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching inventorys:", error);
        }
        
      } catch (error) {
        console.error("Error fetching inventory details:", error);
      }
    },
  },
  mounted() {
    this.getAllInventorys();
  },
  created() {
    this.$root.$on('searchQueryForInventorysChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllInventorys();
    })
  }
};
</script>
<style></style>
