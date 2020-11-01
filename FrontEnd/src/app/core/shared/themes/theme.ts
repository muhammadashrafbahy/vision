export interface Theme {
    name: string;
    properties: any
  }
  
  export const blue: Theme = {
    name: "blue",
    properties: {
      "--background-header" :  "rgba(22,42,52,1)"  ,
      "--background-light" :  "rgba(68,163,197,1)",
      "--background-white" :  "#FFFFFF"  ,
      "--background-sidebarArrow":"#31454d",
      "--background-overlay" :  "rgba(6, 31, 43, 0.8)",
      "--gray":"#e0e0e0",
      "--primary": "#1a8fb9",
  
  
      "--color-dark" :  "#31454e"  ,
      "--color-light" :  "#31454e"  ,
  
      "--font-color-light": "rgba(255, 255, 255, 0.6)",
      "--error-default" :  "#EF3E36"  ,
      "--error-dark" :  "#800600"  ,
      "--error-light" :  "#FFCECC"  ,
  
      "--background-tertiary-shadow" :  "0 1px 3px 0 rgba(92, 125, 153, 0.5)",
    }
  }

  export const green: Theme = {
    name: "green",
    properties: {
  
      "--background-header": "rgba(14, 90, 54, 1)",
      "--background-light": "rgba(57, 175, 91, 1)",
      "--background-overlay": "rgba(14, 90, 54, 0.85)",
      "--background-tertiary": "#08090A",
      "--primary":"#5ca978",
      "--background-sidebarArrow":"#2e6e4f",
      "--gray":"#e0e0e0",
       "--main-color": "#5a5a5a",
      "--color-dark": "#0e5a36",
      "--color-light": "#5ca978",


      
  
      "--primary-default": "#5DFDCB",
      "--primary-dark": "#24B286",
      "--primary-light": "#B2FFE7",
  
      "--error-default": "#EF3E36",
      "--error-dark": "#800600",
      "--error-light": "#FFCECC",
  
      "--background-tertiary-shadow": "0 1px 3px 0 rgba(8, 9, 10, 0.5)",
    }
  }
  
  