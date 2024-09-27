<template>
  <div class="about">
    <h1>welcome {{getUser.email}}</h1>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['getUser'])  
  }
};
</script>