/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.{js,jsx}'],
  darkMode:'class',
  theme: {
    screens: {
      sm: '480px',
      md: '768px',
      lg: '1200px'
    },
    extend: {
      colors: {
        primary: '#71C9CE',
        primaryDark: '#048990',
        secondary: '#A6E3E9',
        secondaryLight: '#CBF1F5',
        textLight: '#E3FDFD',
        textDark: 'rgb(71, 85, 105)',
        dark_primary: '#222831',
        dark_secondary: '#393E46',
        dark_secondaryLight: 'hsl(217, 10%, 55%)',
        dark_light: '#E3FDFD'


      },
      

    }
    
    
  },
  plugins: [],
}
