
export function fizzbuzz(n: number) {

  const fizzbuzzer = (i:  number) : string | number => {
    return i % 15 === 0 ? "fizzbuzz" : i;
  }

  const buzzer = (i: string | number) : string | number => {
    return typeof i === "number" && i % 5 === 0 ? "buzz" : i;
  }

  const fizzer = (i: string | number) : string | number => {
    return typeof i === "number" && i % 3 === 0 ? "fizz" : i;
  }

  return [...Array(n).keys()].map(i => i+1).map(fizzbuzzer).map(buzzer).map(fizzer).join(' ');
}
