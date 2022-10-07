<script setup>
import JoinSocialItem from "../components/JoinSocialItem.vue";
</script>

<template>
  <div class="about">
    <JoinSocialItem />
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
