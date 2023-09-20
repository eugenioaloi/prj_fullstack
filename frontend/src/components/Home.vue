<template>
    <v-app id="inspire">
      <v-navigation-drawer v-model="drawer">
        <v-card
      class="mx-auto"
      width="256"
    >
      <v-layout>
        <v-navigation-drawer permanent absolute>
          <v-list>
            <v-list-item
              prepend-avatar="https://cdn.vuetifyjs.com/images/john.png"
              title="Il tutto fare"
              subtitle="Benvenuto"
            >
              <template v-slot:append>
                <v-btn
                  size="small"
                  variant="text"
                  icon="mdi-menu-down"
                ></v-btn>
              </template>
            </v-list-item>
          </v-list>
  
          <v-divider></v-divider>
  
          <v-list
            :lines="false"
            density="compact"
            nav
          >
            <v-list-item
              v-for="(item, i) in items"
              :key="i"
              :value="item"
              :to = 'item.route'
              color="primary"
            >
              <template v-slot:prepend>
                <v-icon :icon="item.icon"></v-icon>
              </template>
  
              <v-list-item-title v-text="item.text"></v-list-item-title>
  
            </v-list-item>
          </v-list>
        </v-navigation-drawer>
  
        <v-main style="height: 354px;"></v-main>
      </v-layout>
    </v-card>
        
      </v-navigation-drawer>
  
      <v-app-bar>
        <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
  
        <v-app-bar-title>Application</v-app-bar-title>
      </v-app-bar>
  
      <v-main>
        <router-view></router-view>
      </v-main>
    </v-app>
  </template>
  
  <script>
    import { ref } from 'vue'
  
    const drawer = ref(null)
  
    export default {
      data: () => ({
        drawer: null,
        items: [
          { text: 'Things to do', icon: 'mdi-widgets', route: '/'},
          { text: 'About', icon: 'mdi-help-box', route:'/about' },
        ],
  
      }),
    }
  </script>