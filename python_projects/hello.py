import kivy
from kivy.app import App
from kivy.core.window import Window
from kivy.uix.gridlayout import GridLayout
from kivy.uix.label import Label
from kivy.uix.button import Button
from kivy.uix.textinput import TextInput

class CalculatorApp(App):

    def build(self):
        Window.bind(on_rotate=self.on_rotate)
        
        self.window = GridLayout(cols=4, padding=10)

        self.label = Label(text="0", font_size=40, halign="right", valign="center",
                           size_hint=(1, .15), text_size=(400-80, 400*.15-15))
        self.window.add_widget(self.label)

        self.create_buttons()

        return self.window

        def create_buttons(self):
        # existing button creation code
        
        def on_rotate(self, instance, rotation):
            if rotation in [90, 270]:
                # Phone in landscape, add advanced buttons
                self.create_advanced_buttons()
            else:
                # Phone in portrait, remove advanced buttons
                self.window.clear_widgets()
                self.create_buttons()
                self.window.add_widget(self.label)


            
    def create_advanced_buttons(self):
        # Create and add sin, cos, tan buttons
        sin_button = Button(text="sin")
        cos_button = Button(text="cos")
        tan_button = Button(text="tan")
        
        self.window.add_widget(sin_button)
        self.window.add_widget(cos_button)
        self.window.add_widget(tan_button)
        
if __name__ == "__main__":
    CalculatorApp().run()
