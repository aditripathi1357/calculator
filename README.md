# 🧮 Basic Calculator App

A feature-rich Android calculator application built with **Kotlin** that demonstrates UI design, event handling, and mathematical operations. This project showcases modern Material Design principles with both basic and advanced calculator functionality.

## 📱 Features

### Core Functionality
- **Basic Arithmetic Operations** - Addition (+), Subtraction (-), Multiplication (×), Division (÷)
- **Clean Material Design UI** - Modern dark theme with rounded buttons
- **Responsive Button Layout** - Optimized for different screen sizes
- **Real-time Display Updates** - Instant feedback for user inputs

### Enhanced Features
- **🧠 Memory Functions** - M+, M-, MR (Memory Recall), MC (Memory Clear)
- **🔬 Scientific Functions** - Square Root (√), Logarithm (log)
- **🗑️ Clear Operations** - C (Clear current), AC (All Clear), Backspace (⌫)
- **⚡ Advanced Input Handling** - Decimal support, zero handling, operator chaining
- **🛡️ Error Prevention** - Division by zero protection, invalid input handling

## 📸 Screenshots

```
[Calculator Interface]
┌─────────────────────┐
│  Memory: M: 25      │  ← Memory indicator
│                     │
│         1,234.56    │  ← Main display
└─────────────────────┘
┌─────────────────────┐
│ MC  MR  M+  M-      │  ← Memory functions
│ √   log AC  ⌫       │  ← Scientific & clear
│ C   00  .   ÷       │  ← Clear & operators
│ 7   8   9   ×       │
│ 4   5   6   -       │  ← Number pad
│ 1   2   3   +       │
│   0       =         │  ← Zero and equals
└─────────────────────┘
```

## 🛠️ Technical Implementation

### Skills Covered
- **LinearLayout** - Structured button arrangement
- **Button OnClickListeners** - Event handling for user interactions
- **TextView Manipulation** - Dynamic display updates
- **Arithmetic Logic** - Mathematical operation processing
- **String Manipulation** - Number formatting and display
- **Error Handling** - Input validation and edge case management

### Architecture
```
MainActivity
├── Number Input Handling
├── Operator Processing
├── Memory Management
├── Scientific Functions
└── Display Controller
```

## 📂 Project Structure

```
app/src/main/
├── java/com/example/calculator/
│   └── MainActivity.kt              # Main calculator logic
├── res/
│   ├── layout/
│   │   └── activity_calculator.xml  # Calculator UI layout
│   ├── values/
│   │   ├── colors.xml               # Dark theme colors
│   │   ├── styles.xml               # Button styles
│   │   └── strings.xml              # App strings
│   └── drawable/
│       ├── number_button_background.xml
│       ├── operator_button_background.xml
│       ├── function_button_background.xml
│       ├── memory_button_background.xml
│       ├── display_background.xml
│       └── equals_button_background.xml
└── AndroidManifest.xml              # App configuration
```

## 🎯 Learning Objectives

This project demonstrates:

1. **UI Layout Design** - Complex button arrangements using LinearLayout
2. **Event-Driven Programming** - Responding to user button clicks
3. **State Management** - Tracking calculator state and operations
4. **Mathematical Processing** - Implementing arithmetic and scientific functions
5. **Memory Management** - Calculator memory operations (M+, M-, MR, MC)
6. **Error Handling** - Graceful handling of edge cases and invalid inputs
7. **String Formatting** - Number display and formatting
8. **Modern UI Design** - Material Design with dark theme

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK API 21+ (Android 5.0)
- Kotlin plugin enabled

### Installation
1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/android-calculator-app.git
   cd android-calculator-app
   ```

2. **Open in Android Studio**
    - File → Open → Select project folder
    - Wait for Gradle sync to complete

3. **Run the App**
    - Connect Android device or start emulator
    - Click Run button or press `Shift + F10`

### Configuration
- **compileSdk**: 35
- **minSdk**: 21 (Android 5.0+)
- **targetSdk**: 35
- **Orientation**: Portrait (locked)

## 🧪 Testing the App

### Test Cases
1. **Basic Operations** - Test +, -, ×, ÷ with various numbers
2. **Decimal Numbers** - Test calculations with decimal points
3. **Memory Functions** - Test M+, M-, MR, MC operations
4. **Scientific Functions** - Test √ and log operations
5. **Error Handling** - Test division by zero, invalid operations
6. **Clear Functions** - Test C, AC, and backspace functionality
7. **Edge Cases** - Test with very large numbers, multiple operators

### Expected Behaviors
- ✅ Accurate mathematical calculations
- ✅ Proper decimal handling and formatting
- ✅ Memory operations work correctly
- ✅ Error messages for invalid operations
- ✅ Smooth UI interactions and button feedback
- ✅ Display updates in real-time

## 📚 Calculator Operations Guide

### Basic Operations
- **Numbers (0-9)** - Input digits
- **Decimal (.)** - Add decimal point
- **Operators (+, -, ×, ÷)** - Perform calculations
- **Equals (=)** - Execute calculation

### Memory Functions
- **M+** - Add current number to memory
- **M-** - Subtract current number from memory
- **MR** - Recall number from memory
- **MC** - Clear memory

### Scientific Functions
- **√** - Calculate square root of current number
- **log** - Calculate base-10 logarithm

### Clear Functions
- **C** - Clear current input
- **AC** - Clear all (reset calculator)
- **⌫** - Backspace (remove last digit)

## 🔧 Customization Ideas

### Easy Modifications
- Change color scheme in `colors.xml`
- Modify button sizes and spacing
- Add more number formatting options
- Customize display text size and alignment

### Advanced Enhancements
- **History Feature** - Store and recall previous calculations
- **Scientific Mode** - Add trigonometric functions (sin, cos, tan)
- **Unit Converter** - Add length, weight, temperature conversions
- **Themes** - Light/dark mode toggle
- **Voice Input** - Speech-to-text number input
- **Graphing** - Plot mathematical functions
- **Programming Mode** - Binary, hexadecimal, octal calculations

## 🎨 Design Features

### Color Scheme
- **Background** - Dark charcoal (#1E1E1E)
- **Display** - Dark gray with white text
- **Number Buttons** - Dark gray (#3E3E3E)
- **Operator Buttons** - Orange (#FF9500)
- **Function Buttons** - Light gray (#A5A5A5)
- **Memory Buttons** - Blue (#4A90E2)

### Button Styles
- **Rounded corners** - Modern aesthetic
- **Press animations** - Visual feedback
- **Proper spacing** - Easy touch targets
- **Consistent sizing** - Professional appearance

## 🐛 Troubleshooting

### Common Issues
1. **Buttons not responding** - Check OnClickListener setup
2. **Display not updating** - Verify TextView references
3. **Calculation errors** - Check arithmetic logic
4. **Memory not working** - Verify memory variable management
5. **UI layout issues** - Check button weights and margins

### Debug Tips
- Use `Log.d()` to trace calculation steps
- Test each function individually
- Verify button IDs match between XML and Kotlin
- Check for proper error handling in edge cases

## 📚 Learning Resources

- [Android Developer Docs - Layouts](https://developer.android.com/guide/topics/ui/declaring-layout)
- [Material Design - Buttons](https://material.io/components/buttons)
- [Kotlin Math Functions](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/)
- [Android UI Design Patterns](https://developer.android.com/design)

## 🔢 Mathematical Operations Implemented

### Arithmetic
- Addition with overflow handling
- Subtraction with negative number support
- Multiplication with large number handling
- Division with zero-division protection

### Scientific
- Square root with negative input protection
- Base-10 logarithm with domain validation
- Proper floating-point precision handling

## 👨‍💻 Author

Built as part of Android development learning journey, demonstrating UI design, event handling, and mathematical computation in mobile applications.

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

⭐ **Star this repository if it helped you learn Android calculator development!**

## 🤝 Contributing

Feel free to fork this project and submit pull requests for improvements:
- Additional mathematical functions
- UI/UX enhancements
- Performance optimizations
- Bug fixes and error handling improvements