# BDD Bank Instant Payments – React + TypeScript + Vite

This project provides a clean and modern React application setup using Vite, TypeScript, and Playwright, designed for rapid frontend prototyping and testing of real-time payment flows using PayID.

## 🧪 Features

- React 19 + TypeScript + Vite
- Playwright for end-to-end tests with API mocking support
- CSS Modules for component styling
- Support for environment-specific API configuration
- Clean folder structure using Page Object Model for tests

---

## 🧩 PayID Lookup API

The application fetches payee names using a REST-style PayID lookup endpoint:

### **Endpoint**

```
GET /api/payid/lookup?value={payid}
```

### **Query Parameters**

| Param | Type   | Description            |
|-------|--------|------------------------|
| value | string | The PayID to look up   |

### **Example**

```
GET /api/payid/lookup?value=jane@example.com
```

### **Success Response**

```json
{
  "name": "Jane Doe"
}
```

### **Error Response**

```text
Status: 404 Not Found
Body: "Not found"
```

> ℹ️ The base URL for API requests is configured via the `VITE_API_BASE_URL` environment variable. For local development, add the following to your `.env`:

```env
VITE_API_BASE_URL=http://localhost:3000
```

---

## 🧪 End-to-End Tests with Playwright

The E2E tests run against the full app and intercept network calls using Playwright’s routing feature. You can run them with:

```bash
npm run test:e2e
```

Which does the following:

1. Starts the Vite dev server on `http://localhost:5173`
2. Runs Playwright tests against the UI
3. Shuts the dev server down after tests complete

Make sure to install Playwright and `start-server-and-test`:

```bash
npm install --save-dev @playwright/test start-server-and-test
```

Add this to your `package.json`:

```json
"scripts": {
  "dev": "vite",
  "test:e2e": "start-server-and-test dev http://localhost:5173 playwright test"
}
```

---

## 🧑‍💻 Local Development

```bash
npm install
npm run dev
```

Then open [http://localhost:5173](http://localhost:5173) in your browser.

---

## 🧼 Linting and Formatting

This template includes ESLint support with optional stricter rules:

```js
languageOptions: {
  parserOptions: {
    project: ['./tsconfig.node.json', './tsconfig.app.json'],
    tsconfigRootDir: import.meta.dirname,
  },
},
```

For React-specific rules, you can install:

```bash
npm install --save-dev eslint-plugin-react-x eslint-plugin-react-dom
```

---

## 📂 Folder Structure

```
src/
├── components/          # React components
├── pages/               # Page-level components
├── api/                 # API client functions
├── contexts/            # React context providers
├── tests/pages/         # Playwright Page Objects
├── App.tsx              # App routing
└── main.tsx             # App bootstrap
```

---

## 📄 License

MIT – Happy hacking!
