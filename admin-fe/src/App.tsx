import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import routes from "./routers";
import "./App.css";
import Layout from "./components/Layout";

function App() {
  return (
    <Layout>
      <Router>
        <Switch>
          {routes.map((route, i) => (
            <RouteWithSubRoutes key={i} {...route} />
          ))}
        </Switch>
      </Router>
    </Layout>
  );
}

function RouteWithSubRoutes(route: any) {
  return (
    <Route
      path={route.path}
      render={(props: any) => (
        // pass the sub-routes down to keep nesting
        <route.component {...props} routes={route.routes} />
      )}
    />
  );
}

export default App;
