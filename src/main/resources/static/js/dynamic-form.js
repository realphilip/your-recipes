const app = Vue.createApp({});
app.component('dynamic-form', {
    template: `
    <div>
      <input v-model="nameField" placeholder="Name" ref="nameInput">
      <input v-model="ingredientsField" placeholder="Ingredients" @keyup.enter="save()">
      <input v-model="instructionsField" placeholder="Instructions" @keyup.enter="save()">
      <button type="button" @click="save()">Save</button>
    </div>
    <div>
      <h3>Recipes for you:</h3>
        <table>
          <thead>
          <tr>
            <th>Name</th>
            <th>Ingredients</th>
            <th>Instructions</th>
          </tr>
          </thead>
          <tbody>
          <tr v-if="items.length === 0">
            <td colspan="2">There are no recipes so far. Be the first to create one.</td>
          </tr>
          <tr v-for="recipe in items">
            <td>{{recipe.name}}</td>
            <td>{{recipe.ingredients}}</td>
            <td>{{recipe.instructions}}</td>
          </tr>
          <tr>
            <td>{{ nameField }}</td>
            <td>{{ ingredientsField }}</td>
            <td>{{ instructionsField }}</td>
          </tr>
          </tbody>
        </table>
    </div>
  `,
    data() {
        return {
            items: [],
            nameField: '',
            ingredientsField: '',
            instructionsField: '',
        };
    },
    methods: {
        loadRecipes() {
            axios
                .get('/getrecipes')
                .then(response => (this.items = response.data))
        },
        save() {
            axios
                .post('/postrecipes', {
                    name: this.nameField,
                    ingredients: this.ingredientsField,
                    instructions: this.instructionsField
                })
                .then((response) => {
                    this.nameField = '';
                    this.ingredientsField = '';
                    this.instructionsField = '';
                    this.$refs.nameInput.focus();
                    this.loadRecipes();
                }, (error) => {
                    console.log('Your recipe could not be saved');
                });
        },
    },
    mounted: function() {
        this.loadRecipes();
    }
});
app.mount('#dynamic-form');