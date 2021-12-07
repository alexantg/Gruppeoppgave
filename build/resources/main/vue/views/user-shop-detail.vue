<template id="shop-detail">
  <div>

    <ul class="navbar">
      <li><a href="/"> Go tilbake til oversikt over brukere</a></li>
    </ul>

    <h1>{{shop.name}} </h1>
    <p><a class="button" :href="`/user/${shop.name.trim()}/add`">Legg til ny antikvitet</a></p>

    <center> <ul class="item-list">
      <li v-for="item in items">
        <div class="single-item-container" >
          <h1>{{item.name}}</h1>
          <p>{{item.description}}</p>
          <p>{{item.price}}</p>
          <img v-if="item.pictureUrl" class="cover-image" v-bind:src="item.pictureUrl">
          <p><a class="shopButton">Oppdater antikvitet</a></p>
          <p><a class="shopButton">Fjern antikvitet</a></p>
        </div>
      </li>
    </ul>
    </center>
  </div>
</template>

<script>
  Vue.component("user-shop-detail",{
    template:"#shop-detail",

    data:() =>({
      items: [],
      shop:null
    }),

    created(){
      const shopId = this.$javalin.pathParams["shop-id"]
      fetch(`/api/user/${shopId}`)
      .then(res => res.json())
      .then(res => this.shop = res)
      .catch(() => alert("Error"))

      fetch(`/api/items/${shopId}`)
          .then(res => res.json())
          .then(res =>{
            this.items = res;
          })
          .catch(() => alert("Error while fetching items"));
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

.navbar {
  overflow: hidden;
  background-color: slategrey;
}

.navbar li {
  float: left;
}

.navbar li a {
  display: block;
  color: white;
  text-align: center;
  padding: 12px 14px;
}

.navbar li a:hover {
  background-color: #111;
}

.item-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.shopButton {
  background-color: black;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin: 4px 2px;
  cursor: pointer;
}

</style>