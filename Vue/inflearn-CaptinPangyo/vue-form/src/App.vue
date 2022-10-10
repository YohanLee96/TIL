<template>
  <form v-on:submit.prevent="submitForm">
    <div>
      <label for="userName">id : </label>
      <input id="userName" type="text" v-model="userName">
    </div>
    <div>
      <label for="password">pw : </label>
      <input id="password" type="password" v-model="password">
    </div>
    <button type="submit" v-on:click="submitForm">login</button>
  </form>
</template>

<script>
import axios from 'axios'

export default {
  data : function () {
    return {
      userName : '',
      password : '', 
    }
  },
  methods : {
    submitForm : function(){
   
     
      var url ="https://jsonplaceholder.typicode.com/users";
      var data = {
        userName : this.userName,
        password : this.password
      }
      axios.post(url,data)
        .then(function(response){
          console.log(response);         
        })
        .catch(function(error) {
          console.log(error);
        });
          
    }
  }
}
</script>

<style>

</style>