# Introduction

When developing new DropWizard applications which require dynamic updates during development only then use this library.

Note: This should not be used for end user rendering - performance will be impacted.

# Usage

Add the following to your initialize method.

    bootstrap.addBundle(new NonCachineMustacheViewBundle());


