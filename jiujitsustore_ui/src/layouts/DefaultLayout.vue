<template>
  <a-layout style="min-height: 100vh">
    <!-- Header -->
    <a-layout-header style="background: #fff; padding: 0">
      <app-header />
    </a-layout-header>

    <!-- Main layout with sider and content -->
    <a-layout>
      <!-- Collapsible Sider with Controlled Open Keys for Nested Menu -->
      <a-layout-sider width="200px" collapsible style="background: #fff">
        <a-menu
          mode="inline"
          :openKeys="openKeys"
          @openChange="onOpenChange"
          style="height: 100%; border-right: 0"
        >
<!--          <a-sub-menu key="sub1" title="Menu 1">
            <a-menu-item key="1">Option 1</a-menu-item>
            <a-menu-item key="2">Option 2</a-menu-item>
            <a-sub-menu key="sub1-1" title="Nested Menu">
              <a-menu-item key="3">Option 3</a-menu-item>
              <a-menu-item key="4">Option 4</a-menu-item>
            </a-sub-menu>
          </a-sub-menu>
          <a-sub-menu key="sub2" title="Menu 2">
            <a-menu-item key="5">Option 5</a-menu-item>
            <a-menu-item key="6">Option 6</a-menu-item>
          </a-sub-menu>
-->>

	 
			
				<a-menu-item>
					<router-link to="/staffs">
						<span class="label">Staffs</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/wishlists">
						<span class="label">Wishlists</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/carts">
						<span class="label">Carts</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/reviews">
						<span class="label">Reviews</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/suppliers">
						<span class="label">Suppliers</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/payments">
						<span class="label">Payments</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/categorys">
						<span class="label">Categorys</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/promotions">
						<span class="label">Promotions</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/stores">
						<span class="label">Stores</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/discounts">
						<span class="label">Discounts</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/shipments">
						<span class="label">Shipments</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/wishlistItems">
						<span class="label">Wishlist Items</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/cartItems">
						<span class="label">Cart Items</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/coupons">
						<span class="label">Coupons</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/inventorys">
						<span class="label">Inventorys</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/orderItems">
						<span class="label">Order Items</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/addresss">
						<span class="label">Addresss</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/customers">
						<span class="label">Customers</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/orders">
						<span class="label">Orders</span>
					</router-link>
				</a-menu-item>
		
				<a-menu-item>
					<router-link to="/products">
						<span class="label">Products</span>
					</router-link>
				</a-menu-item>
		
	
        </a-menu>
      </a-layout-sider>
      
      <!-- Content area -->
      <a-layout-content style="padding: 16px">
        <router-view />
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>

<script>
import { ref } from "vue";
import AppHeader from "@/components/AppHeader.vue";

export default {
  name: "DefaultLayout",
  components: {
    AppHeader,
  },
  setup() {
    const openKeys = ref(["sub1"]); // default open submenu
    const onOpenChange = (keys) => {
      // Open only the last clicked submenu, for single open behavior
      openKeys.value = keys.length ? [keys[keys.length - 1]] : [];
    };

    return {
      openKeys,
      onOpenChange,
    };
  },
};
</script>
<style>
.ant-layout {
    margin-top: 20px;
}
</style>

