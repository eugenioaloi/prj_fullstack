<template>
    <div class="d-flex align-center justify-center" style="height: 10vh">
        <h1>Login</h1>
    </div>
    <div class="d-flex align-center justify-center" style="height: 50vh">
        <v-sheet width="400" class="mx-auto">
            <v-form @submit.prevent="handleRegistration">
                <v-text-field 
                v-model="nome" label="Insert name"
                />
                <v-text-field 
                v-model="cognome" label="Insert surname"
                />
                <v-text-field 
                v-model="email" label="Insert email"
                />
                <v-text-field 
                v-model="password" label="Insert password"
                />
                <v-text-field 
                v-model="password" label="Repeat password"
                />
                <v-btn 
                type="submit" 
                color="primary" 
                block class="mt-2">
                    Sign to portal
                </v-btn>
            </v-form>
        </v-sheet>
    </div>
</template>

<script>

export default{

    data() {
        return {
            username: '',
            password: '',
        };
    },
    methods: {
        handleRegistration(){
            console.log("email", this.email);
            console.log("password", this.password);
        }, 
    },
}

</script>
