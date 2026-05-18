<script setup>
import { onMounted, ref } from 'vue'
import api from '../services/api'

const users = ref([])
const username = ref('')

const loadUsers = async () => {
  const res = await api.get('/users')
  users.value = res.data
}

onMounted(loadUsers)

const saveUser = async () => {
  if (!username.value) return

  await api.post('/users', {   // ← als je backend @PostMapping gebruikt
    username: username.value
  })

  username.value = ''
  loadUsers() // refresh lijst
}
</script>

<template>
  <div>
    <h1>Users</h1>

    <!-- formulier -->
    <input v-model="username" placeholder="username" />
    <button @click="saveUser">Opslaan</button>

    <ul>
      <li v-for="u in users" :key="u.id">
        ({{ u.username }})
      </li>
    </ul>
  </div>
</template>