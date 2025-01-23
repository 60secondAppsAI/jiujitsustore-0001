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
            <store-table
            v-if="stores && stores.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:stores="stores"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-stores="getAllStores"
             >

            </store-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import StoreTable from "@/components/StoreTable";
import StoreService from "../services/StoreService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    StoreTable,
  },
  data() {
    return {
      stores: [],
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
    async getAllStores(sortBy='storeId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await StoreService.getAllStores(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.stores.length) {
					this.stores = response.data.stores;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching stores:", error);
        }
        
      } catch (error) {
        console.error("Error fetching store details:", error);
      }
    },
  },
  mounted() {
    this.getAllStores();
  },
  created() {
    this.$root.$on('searchQueryForStoresChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllStores();
    })
  }
};
</script>
<style></style>
