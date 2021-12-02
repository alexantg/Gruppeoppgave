<template id="shop-detail">
  <div>
    <center>
    <h1>{{shop.name}}</h1>
    <p>{{shop.address}}</p>
    <p><a class="button" :href="`/user/${shop.name.trim()}/add`">Legg til ny antikvitet</a></p>
    </center>
  </div>
</template>

<script>
  Vue.component("user-shop-detail",{
    template:"#shop-detail",

    data:() =>({
      shop:null
    }),

    created(){
      const shopId = this.$javalin.pathParams["shop-id"]

      fetch(`/api/user/${shopId}`)
      .then(res => res.json())
      .then(res => this.shop = res)
      .catch(() => alert("Error"))

    }

  });

</script>

<style>
h1{
  font-size: 50px;
  color: black;
}
p{
  font-size: 20px;
}

</style>