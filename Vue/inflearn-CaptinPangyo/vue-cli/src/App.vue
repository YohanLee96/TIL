<template>
  <div>
    <app-header 
      v-bind:propsdata="str"
      v-on:renew="renewStr"></app-header>
  </div>
</template>

<script>
import AppHeader from './components/AppHeader.vue';

export default {
  data : function(){
    return {
      str: 'johnxx1'
    }
  },
  components : {
    'app-header' : AppHeader
  },
  methods : {
    renewStr: function(){
      if(this.str == "johnxx1"){
        this.str = "fuckYou!!";
      }else{
        this.str = "johnxx1";
      }
      
    }
  }
}
</script>

<style>

</style>