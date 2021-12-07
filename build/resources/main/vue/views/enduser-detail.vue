<template id="enduser-detail">
    <div>
      <ul class="navbar">
        <li><a href="/"> Go back to login page</a></li>
      </ul>

      <center> <h2>Antiques</h2></center>
      <center> <ul class="item-list">
        <li v-for="item in items">
            <div class="single-item-container" >
              <h1>{{item.name}}</h1>
              <p>{{item.description}}</p>
              <p>{{item.price}}</p>
              <img v-if="item.pictureUrl" class="cover-image" v-bind:src="item.pictureUrl">
              <p><a class="button" :href="`/enduser/${shopName}/items/${item.name}`">Kjøp nå</a></p>
            </div>
        </li>
      </ul>
      </center>
    </div>
</template>

<script>
Vue.component("enduser-detail",
    {template: "#enduser-detail",
      data: () => ({
        items: [],
        shopName: "",
      }),
      created(){
        const shopId = this.$javalin.pathParams["shop-id"]
        this.shopName = shopId;
        fetch(`/api/items/${shopId}`)
            .then(res => res.json())
            .then(res =>{
              this.items = res;
            })
            .catch(() => alert("Error while fetching saved items"));
      },
    });

</script>
<style>

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

li {
  list-style-type: none;
}

.item-list li {
  padding: 10px;
}

div.single-item-container {
  overflow: hidden;
  width: 300px;
  background-color: white;
  opacity: 0.96;
  text-align: center;
  border: 1px solid black ;
  border-radius: 15px;
  margin: 20px;
}

div.single-item-container:hover {
  opacity: 1.0;
  overflow: hidden;
  -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
  -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
  box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
}

img.cover-image {
  width: 125px;
  height: 125px;
  padding-bottom: 20px;
  max-height: 280px;
}

.button {
  padding: 15px;
  margin: 10px;
  border: 2px solid black;
  color: black;
  border-radius: 15px;
}

.button a {
  color: black;
  text-decoration: none;
  font-weight: bold;
}

.button:hover {
  border: 2px solid black;
}

h2{
  font-size: 40px;
  text-decoration: none;
  color: black;
}

p {
  padding-bottom: 5px;
}
</style>