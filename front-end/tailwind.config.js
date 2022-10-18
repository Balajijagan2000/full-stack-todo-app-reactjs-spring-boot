/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.{js,jsx}'],
  theme: {
    screens: {
      sm: '480px',
      md: '768px',
      lg: '1200px'
    },
    extend: {
      colors: {
        primary: '#71C9CE',
        secondary: '#A6E3E9',
        secondaryLight: '#CBF1F5',
        light: '#E3FDFD'
      }
      // colors: {
      //   primary: '#222831',
      //   secondary: '#393E46',
      //   secondaryLight: 'hsl(217, 10%, 55%)',
      //   light: '#E3FDFD'
      // }

    }
    
    
  },
  plugins: [],
}
