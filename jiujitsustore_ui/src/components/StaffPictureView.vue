<template> 





</template>
  
<script>

export default {
    components: {
    },
    props: {
        staffs: Array,
    },

    methods: {

    },
};
</script>
  
<style scoped>
.card-container {
    display: flex;
    column-gap: 15px;
    flex-wrap: wrap;
    margin: 5px;

}

.card {
    max-width: 230px;

}

.staff-picture-view {
    margin-bottom: 15px;
    /* Separate each row from the content below */
}

.staff-card {
    max-width: 250px;
    min-width: 250px;
    border-radius: 30px;
    padding: 0px;
    margin-bottom: 25px;
    /* Separate each card */
}

.staff-image {
				    	width: 250px;
	    	height: 200px;
	    	        	border-radius: 4px;
    }

.staff-info {
    margin-top: 0px;
}

.staff-name {
    font-weight: bold;
    font-size: 16px;
    margin-bottom: 2px;
    line-height: 1.2;
}

.staff-details p {
    margin-top: 0px;
    text-align: left;
}

.staff-link {
    display: inline;
    margin-top: 5px;
    color: #1890ff;
}
</style>
  
