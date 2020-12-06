<template>
  {{ currentUser.id }}
  {{ currentUser.username }}
  {{ currentUser.email }}
</template>

<script>
export default {
  name: 'Profile',
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
  }
}
</script>

<style scoped>

</style>
