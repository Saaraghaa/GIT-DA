// Import the events module
var events = require('events');
// Create an eventEmitter object
var eventEmitter = new events.EventEmitter();
// Function to perform arithmetic operations
var arithmeticOperations = function (num1, num2) {
console.log('Arithmetic Operations:');
console.log('----------------------');
console.log('Numbers: ' + num1 + ', ' + num2);
console.log('Addition: ' + (num1 + num2));
console.log('Subtraction: ' + (num1 - num2));
console.log('Multiplication: ' + (num1 * num2));
console.log('Division: ' + (num1 / num2));
console.log('----------------------');
}
// Bind the arithmeticOperations function with the event
eventEmitter.on('arithmetic', arithmeticOperations);
// Check if the required command line arguments are provided
if (process.argv.length < 4) {
console.error('Please provide two numbers as arguments.');
process.exit(1);
}
// Parse the command line arguments to numbers
var num1 = parseFloat(process.argv[2]);
var num2 = parseFloat(process.argv[3]);
// Emit the event with the parsed numbers
eventEmitter.emit('arithmetic', num1, num2);
// Remove the event listener
eventEmitter.removeListener('arithmetic', arithmeticOperations);
