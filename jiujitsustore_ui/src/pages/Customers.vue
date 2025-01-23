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
            <customer-table
            v-if="customers && customers.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:customers="customers"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-customers="getAllCustomers"
             >

            </customer-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import CustomerTable from "@/components/CustomerTable";
import CustomerService from "../services/CustomerService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    CustomerTable,
  },
  data() {
    return {
      customers: [],
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
    async getAllCustomers(sortBy='customerId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await CustomerService.getAllCustomers(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.customers.length) {
					this.customers = response.data.customers;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching customers:", error);
        }
        
      } catch (error) {
        console.error("Error fetching customer details:", error);
      }
    },
  },
  mounted() {
    this.getAllCustomers();
  },
  created() {
    this.$root.$on('searchQueryForCustomersChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllCustomers();
    })
  }
};
</script>
<style></style>
