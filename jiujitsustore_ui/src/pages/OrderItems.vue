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
            <orderItem-table
            v-if="orderItems && orderItems.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:orderItems="orderItems"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-order-items="getAllOrderItems"
             >

            </orderItem-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import OrderItemTable from "@/components/OrderItemTable";
import OrderItemService from "../services/OrderItemService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    OrderItemTable,
  },
  data() {
    return {
      orderItems: [],
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
    async getAllOrderItems(sortBy='orderItemId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await OrderItemService.getAllOrderItems(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.orderItems.length) {
					this.orderItems = response.data.orderItems;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching orderItems:", error);
        }
        
      } catch (error) {
        console.error("Error fetching orderItem details:", error);
      }
    },
  },
  mounted() {
    this.getAllOrderItems();
  },
  created() {
    this.$root.$on('searchQueryForOrderItemsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllOrderItems();
    })
  }
};
</script>
<style></style>
