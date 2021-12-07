<template id="mainpage-enduser">
  <div>
    <div>
      <center> <h2>Oversikt over butikker </h2></center>
      <center> <ul class="shop-overview-list">
        <li v-for="shop in shops">
          <a :href="`/enduser/${shop.name.trim()}`">
            <div class="single-shop-container" >
              <h1>{{shop.name}}</h1>
            </div>
          </a>
        </li>
      </ul>
      </center>
    </div>
  </div>
</template>

<script>
Vue.component("mainpage-enduser",
    {template: "#mainpage-enduser",
      data: () => ({
        shops: [],
      }),
      created(){
        fetch("/api/shops")
            .then(res => res.json())
            .then(res =>{
              this.shops = res;
            })
            .catch(() => alert("Error while fetching saved shops"));
      }

    });

</script>
<style>

li{
  list-style-type: none;
}

.shop-overview-list li{
  padding: 10px;

}

div.single-shop-container{
  overflow: hidden;
  width: 300px;
  background-color: white;
  opacity: 0.96;
  text-align: center;
  border: 1px solid black ;
  border-radius: 15px;
  margin: 20px;
}

div.single-shop-container:hover{
  opacity: 1.0;
  overflow: hidden;
  -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
  -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
  box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
}

.button a{
  color: black;
  text-decoration: none;
  font-weight: bold;
}

h2{
  font-size: 40px;
  text-decoration: none;
  color: black;

}
</style>