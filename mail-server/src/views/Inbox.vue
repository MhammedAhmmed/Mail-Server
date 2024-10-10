<template>
  <Header name="Inbox"/>
  <SideBar/>
  <MailSendingVue/>

</template>

<script>
import MailSendingVue from '@/components/MailSending.vue'
import Header from '../components/Header.vue'
import SideBar from '../components/SideBar.vue'
import Filter from '../components/Filter.vue'
export default {
  components: { Header,SideBar,Filter,MailSendingVue },
  
}
</script>

<style>

</style>