<template id="mainpage-enduser">
  <!-- <div class="app">
  <center><h1>End User</h1>
    <p>Test paragraph</p>
  </center>
  </div> -->
  <div>
    <ul class="navbar">
      <li class="navbar-list"><a class="active" href="/">Homepage</a></li>
      <li class="navbar-list"><a href="#news">Placeholder1</a></li>
      <li class="navbar-list"><a href="#contact">Placeholder2</a></li>
      <li class="navbar-list" style="float:right"><a href="#about">Placeholder3</a></li>
    </ul>
    <ul class="items-overview-list">
      <li v-for="item in items">
        <a :href="`/item/${item.name.trim()}`" class="link-to-item">
          <div class="single-item-container">
            <h1>{{item.name}}</h1>
            <img v-if="item.pictureUrl" class="cover-image-frontpage" v-bind:src="item.pictureUrl">
            <img v-else class="cover-image-frontpage" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
            <p>{{item.price}} kroner</p>
          </div>
        </a>
      </li>
    </ul>
  </div>
</template>

<script>
 Vue.component("mainpage-enduser", {
    template: "#mainpage-enduser",
    data: () => ({
      items:[],
    }),
    created() {
      fetch("/api/item")
          .then(res => res.json())
          .then(res => {
            this.items = res;
          })
      .catch(() => alert("Error, could not fetch the items"))
    }
  });

</script>

<style>
    .navbar {
      list-style-type: none;
      margin: 0;
      padding: 0;
      overflow: hidden;
      background-color: #333;
    }
    .navbar-list {
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
      float: left;
    }
    a {
      text-decoration: none;
      color: white;
    }

    body {
      background-color: white;
    }
    p {
      text-transform: uppercase;
      font-size: 150%;
    }

    li{
      list-style-type: none;
    }

    .items-overview-list{
      display: flex;
      flex-wrap: wrap-reverse;
      justify-content: center;
    }

    .items-overview-list li{
      padding: 10px;
      border: 1px solid white;
      border-radius: 15px;
    }

    .link-to-item{
      width: 400px;
      height: 100px;
      text-decoration: none;
      color: white;
    }

    div.single-item-container{
      overflow: hidden;
      width: 500px;
      background-color: #757575;
      margin: 0 auto;
      opacity: 0.96;
      text-align: center;
    }

    div.single-item-container:hover{
      opacity: 1.0;
      overflow: hidden;
      -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
      -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
      box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.cover-image-frontpage {
      height: auto;
      width: 80%;
      padding-bottom: 20px;
      max-height: 280px;
    }
</style>