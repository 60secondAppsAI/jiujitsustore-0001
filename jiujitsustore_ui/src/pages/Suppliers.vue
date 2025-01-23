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
            <supplier-table
            v-if="suppliers && suppliers.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:suppliers="suppliers"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-suppliers="getAllSuppliers"
             >

            </supplier-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import SupplierTable from "@/components/SupplierTable";
import SupplierService from "../services/SupplierService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    SupplierTable,
  },
  data() {
    return {
      suppliers: [],
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
    async getAllSuppliers(sortBy='supplierId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await SupplierService.getAllSuppliers(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.suppliers.length) {
					this.suppliers = response.data.suppliers;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching suppliers:", error);
        }
        
      } catch (error) {
        console.error("Error fetching supplier details:", error);
      }
    },
  },
  mounted() {
    this.getAllSuppliers();
  },
  created() {
    this.$root.$on('searchQueryForSuppliersChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllSuppliers();
    })
  }
};
</script>
<style></style>
