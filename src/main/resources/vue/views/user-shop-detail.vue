<template id="shop-detail">
  <div>

    <h1>{{shop.name}}</h1>

    <p><a class="button" href="additem/">Legg til ny antikvitet</a></p>

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
  color: black;
}

</style>