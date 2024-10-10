<template>
  <Header name="Trash"/>
  <SideBar/>
  <BodyVue/>

</template>

<script>
import Header from '../components/Header.vue'
import SideBar from '../components/SideBar.vue'
import BodyVue from '@/components/Body.vue'
export default {
  components: { Header,SideBar,BodyVue},
  
}
</script>

<style>

</style>