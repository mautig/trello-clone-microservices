import { useAuth0 } from "@auth0/auth0-react";

function App() {
  const { user, loginWithRedirect, isAuthenticated } = useAuth0();

  return (
    <div className="App">
      Trello App
      {isAuthenticated ? (
        user?.email
      ) : (
        <button onClick={() => loginWithRedirect()}>login</button>
      )}
    </div>
  );
}

export default App;
