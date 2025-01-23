import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import Staffs from  '@/pages/Staffs.vue';
import StaffDetail from  '@/pages/StaffDetail.vue';
import Wishlists from  '@/pages/Wishlists.vue';
import WishlistDetail from  '@/pages/WishlistDetail.vue';
import Carts from  '@/pages/Carts.vue';
import CartDetail from  '@/pages/CartDetail.vue';
import Reviews from  '@/pages/Reviews.vue';
import ReviewDetail from  '@/pages/ReviewDetail.vue';
import Suppliers from  '@/pages/Suppliers.vue';
import SupplierDetail from  '@/pages/SupplierDetail.vue';
import Payments from  '@/pages/Payments.vue';
import PaymentDetail from  '@/pages/PaymentDetail.vue';
import Categorys from  '@/pages/Categorys.vue';
import CategoryDetail from  '@/pages/CategoryDetail.vue';
import Promotions from  '@/pages/Promotions.vue';
import PromotionDetail from  '@/pages/PromotionDetail.vue';
import Stores from  '@/pages/Stores.vue';
import StoreDetail from  '@/pages/StoreDetail.vue';
import Discounts from  '@/pages/Discounts.vue';
import DiscountDetail from  '@/pages/DiscountDetail.vue';
import Shipments from  '@/pages/Shipments.vue';
import ShipmentDetail from  '@/pages/ShipmentDetail.vue';
import WishlistItems from  '@/pages/WishlistItems.vue';
import WishlistItemDetail from  '@/pages/WishlistItemDetail.vue';
import CartItems from  '@/pages/CartItems.vue';
import CartItemDetail from  '@/pages/CartItemDetail.vue';
import Coupons from  '@/pages/Coupons.vue';
import CouponDetail from  '@/pages/CouponDetail.vue';
import Inventorys from  '@/pages/Inventorys.vue';
import InventoryDetail from  '@/pages/InventoryDetail.vue';
import OrderItems from  '@/pages/OrderItems.vue';
import OrderItemDetail from  '@/pages/OrderItemDetail.vue';
import Addresss from  '@/pages/Addresss.vue';
import AddressDetail from  '@/pages/AddressDetail.vue';
import Customers from  '@/pages/Customers.vue';
import CustomerDetail from  '@/pages/CustomerDetail.vue';
import Orders from  '@/pages/Orders.vue';
import OrderDetail from  '@/pages/OrderDetail.vue';
import Products from  '@/pages/Products.vue';
import ProductDetail from  '@/pages/ProductDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
																						redirect: '/products',
	  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/staffs',
		name: 'Staffs',
		layout: DefaultLayout,
		component: Staffs,
	},
	{
	    path: '/staff/:staffId', 
	    name: 'StaffDetail',
		layout: DefaultLayout,
	    component: StaffDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/wishlists',
		name: 'Wishlists',
		layout: DefaultLayout,
		component: Wishlists,
	},
	{
	    path: '/wishlist/:wishlistId', 
	    name: 'WishlistDetail',
		layout: DefaultLayout,
	    component: WishlistDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/carts',
		name: 'Carts',
		layout: DefaultLayout,
		component: Carts,
	},
	{
	    path: '/cart/:cartId', 
	    name: 'CartDetail',
		layout: DefaultLayout,
	    component: CartDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/reviews',
		name: 'Reviews',
		layout: DefaultLayout,
		component: Reviews,
	},
	{
	    path: '/review/:reviewId', 
	    name: 'ReviewDetail',
		layout: DefaultLayout,
	    component: ReviewDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/suppliers',
		name: 'Suppliers',
		layout: DefaultLayout,
		component: Suppliers,
	},
	{
	    path: '/supplier/:supplierId', 
	    name: 'SupplierDetail',
		layout: DefaultLayout,
	    component: SupplierDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/payments',
		name: 'Payments',
		layout: DefaultLayout,
		component: Payments,
	},
	{
	    path: '/payment/:paymentId', 
	    name: 'PaymentDetail',
		layout: DefaultLayout,
	    component: PaymentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/categorys',
		name: 'Categorys',
		layout: DefaultLayout,
		component: Categorys,
	},
	{
	    path: '/category/:categoryId', 
	    name: 'CategoryDetail',
		layout: DefaultLayout,
	    component: CategoryDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/promotions',
		name: 'Promotions',
		layout: DefaultLayout,
		component: Promotions,
	},
	{
	    path: '/promotion/:promotionId', 
	    name: 'PromotionDetail',
		layout: DefaultLayout,
	    component: PromotionDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/stores',
		name: 'Stores',
		layout: DefaultLayout,
		component: Stores,
	},
	{
	    path: '/store/:storeId', 
	    name: 'StoreDetail',
		layout: DefaultLayout,
	    component: StoreDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/discounts',
		name: 'Discounts',
		layout: DefaultLayout,
		component: Discounts,
	},
	{
	    path: '/discount/:discountId', 
	    name: 'DiscountDetail',
		layout: DefaultLayout,
	    component: DiscountDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/shipments',
		name: 'Shipments',
		layout: DefaultLayout,
		component: Shipments,
	},
	{
	    path: '/shipment/:shipmentId', 
	    name: 'ShipmentDetail',
		layout: DefaultLayout,
	    component: ShipmentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/wishlistItems',
		name: 'WishlistItems',
		layout: DefaultLayout,
		component: WishlistItems,
	},
	{
	    path: '/wishlistItem/:wishlistItemId', 
	    name: 'WishlistItemDetail',
		layout: DefaultLayout,
	    component: WishlistItemDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/cartItems',
		name: 'CartItems',
		layout: DefaultLayout,
		component: CartItems,
	},
	{
	    path: '/cartItem/:cartItemId', 
	    name: 'CartItemDetail',
		layout: DefaultLayout,
	    component: CartItemDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/coupons',
		name: 'Coupons',
		layout: DefaultLayout,
		component: Coupons,
	},
	{
	    path: '/coupon/:couponId', 
	    name: 'CouponDetail',
		layout: DefaultLayout,
	    component: CouponDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/inventorys',
		name: 'Inventorys',
		layout: DefaultLayout,
		component: Inventorys,
	},
	{
	    path: '/inventory/:inventoryId', 
	    name: 'InventoryDetail',
		layout: DefaultLayout,
	    component: InventoryDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/orderItems',
		name: 'OrderItems',
		layout: DefaultLayout,
		component: OrderItems,
	},
	{
	    path: '/orderItem/:orderItemId', 
	    name: 'OrderItemDetail',
		layout: DefaultLayout,
	    component: OrderItemDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/addresss',
		name: 'Addresss',
		layout: DefaultLayout,
		component: Addresss,
	},
	{
	    path: '/address/:addressId', 
	    name: 'AddressDetail',
		layout: DefaultLayout,
	    component: AddressDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/customers',
		name: 'Customers',
		layout: DefaultLayout,
		component: Customers,
	},
	{
	    path: '/customer/:customerId', 
	    name: 'CustomerDetail',
		layout: DefaultLayout,
	    component: CustomerDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/orders',
		name: 'Orders',
		layout: DefaultLayout,
		component: Orders,
	},
	{
	    path: '/order/:orderId', 
	    name: 'OrderDetail',
		layout: DefaultLayout,
	    component: OrderDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/products',
		name: 'Products',
		layout: DefaultLayout,
		component: Products,
	},
	{
	    path: '/product/:productId', 
	    name: 'ProductDetail',
		layout: DefaultLayout,
	    component: ProductDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
